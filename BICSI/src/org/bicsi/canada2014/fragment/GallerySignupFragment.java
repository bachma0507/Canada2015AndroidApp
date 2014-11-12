package org.bicsi.canada2014.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Intent;

import org.bicsi.winter2015.R;
import org.bicsi.canada2014.activities.MainActivity;
import org.bicsi.canada2014.activities.Welcome;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;

public class GallerySignupFragment extends Fragment {
	
	
	// Declare Variables
			Button loginbutton;
			Button signup;
			String usernametxt;
			String passwordtxt;
			String emailtxt;
			EditText password;
			EditText username;
			EditText email;
			
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				super.onCreateView(inflater, container, savedInstanceState);
				View v = inflater.inflate(R.layout.gallery_signup, container, false);
				
				
				username = (EditText) v.findViewById(R.id.username);
				password = (EditText) v.findViewById(R.id.password);
				email = (EditText) v.findViewById(R.id.email);

				// Locate Buttons in gallery_signup.xml
				signup = (Button) v.findViewById(R.id.signup);
				
				// Sign up Button Click Listener
				signup.setOnClickListener(new OnClickListener() {

					public void onClick(View arg0) {
						// Retrieve the text entered from the EditText
						usernametxt = username.getText().toString();
						emailtxt = email.getText().toString();
						passwordtxt = password.getText().toString();
						
						// Force user to fill up the form
						if (usernametxt.equals("") || passwordtxt.equals("") || emailtxt.equals("")) {
							Toast.makeText(getActivity(),
									"Please complete the sign up form",
									Toast.LENGTH_LONG).show();

						} else {
							// Save new user data into Parse.com Data Storage
							ParseUser user = new ParseUser();
							user.setUsername(usernametxt);
							user.setEmail(emailtxt);
							user.setPassword(passwordtxt);
							user.put("emailCopy", (emailtxt));
							user.put("fullname", (usernametxt));
							user.put("fullname_lower", (usernametxt));
							user.signUpInBackground(new SignUpCallback() {
								public void done(ParseException e) {
									if (e == null) {
										// Show a simple Toast message upon successful registration
										Toast.makeText(getActivity(),
												"Successfully Signed up, please log in.",
												Toast.LENGTH_LONG).show();
									} else {
										Toast.makeText(getActivity(),
												"Sign up Error", Toast.LENGTH_LONG)
												.show();
									}
								}
							});
						}

					}
				});

	
				return v;
			}

}
