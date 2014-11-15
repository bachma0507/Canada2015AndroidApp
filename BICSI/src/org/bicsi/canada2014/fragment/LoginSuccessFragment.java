package org.bicsi.canada2014.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Context;
import android.content.Intent;

import org.bicsi.winter2015.R;
import org.bicsi.canada2014.activities.MainActivity;
import org.bicsi.canada2014.activities.Welcome;

import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;

public class LoginSuccessFragment extends Fragment {
	private NavigateToTabFragmentListener mCallback;
	
	// Declare Variables
			Button viewGalleryButton;
			Button uploadPhotoButton;
			
			public void onAttach(Activity activity) {
				super.onAttach(activity);

				try {
					mCallback = (NavigateToTabFragmentListener) activity;
				} catch (ClassCastException e) {
					throw new ClassCastException(activity.toString()
							+ " must implement NavigateToListener");
				}
			}
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				super.onCreateView(inflater, container, savedInstanceState);
				View v = inflater.inflate(R.layout.loginsuccess, container, false);
				
				// Locate Buttons in loginsuccess.xml
				viewGalleryButton = (Button) v.findViewById(R.id.viewgallerybtn);
				uploadPhotoButton = (Button) v.findViewById(R.id.uploadphotobtn);
				
				
				v.setOnTouchListener(new OnTouchListener()
				{
				    @Override
				    public boolean onTouch(View view, MotionEvent ev)
				    {
				        hideKeyboard(view);
				        return false;
				    }

				});
				
				return v;
			}
			
			/**
			* Hides virtual keyboard
			*
			* @author kvarela
			*/
			protected void hideKeyboard(View view)
			{
			    InputMethodManager in = (InputMethodManager) ((getActivity())).getSystemService(Context.INPUT_METHOD_SERVICE);
			    in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
}
