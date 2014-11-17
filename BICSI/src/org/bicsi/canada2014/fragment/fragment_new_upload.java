package org.bicsi.canada2014.fragment;

import java.util.List;

import org.bicsi.winter2015.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.bicsi.canada2014.activities.NewMealActivity;
import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;

import org.bicsi.canada2014.Meal;


public class fragment_new_upload extends Fragment {
	
	private NavigateToTabFragmentListener mCallback;
	
	
	private ImageButton photoButton;
	private Button saveButton;
	private Button cancelButton;
	private TextView comment;
	//private Spinner mealRating;
	private ParseImageView photoPreview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		ParseUser.getCurrentUser().saveInBackground();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle SavedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_new_upload, parent, false);
	
		comment = ((EditText) v.findViewById(R.id.comment));
		
		photoButton = ((ImageButton) v.findViewById(R.id.photo_button));
		photoButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(comment.getWindowToken(), 0);
				startCamera();
			}
		});
		
		saveButton = ((Button) v.findViewById(R.id.save_button));
		saveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//ParseObject.registerSubclass(Meal.class);
				
				/*ParseObject wallimageobject = new ParseObject("WallImageObject");
				wallimageobject.put("user", (ParseUser.getCurrentUser()));
				wallimageobject.put("comment", (mealName.getText().toString()));*/
				
				Meal meal = ((NewMealActivity) getActivity()).getCurrentMeal();

				// When the user clicks "Save," upload the meal to Parse
				// Add data to the meal object:
				meal.setTitle(comment.getText().toString());
				
				
				
				String struser = (ParseUser.getCurrentUser()).toString();
				
				// Associate the meal with the current user
				meal.setAuthor(ParseUser.getCurrentUser());
				meal.setUser(struser);

				// Add the rating
				//meal.setRating(mealRating.getSelectedItem().toString());

				// If the user added a photo, that data will be
				// added in the CameraFragment

				// Save the meal and return
				meal.saveInBackground(new SaveCallback() {

					@Override
					public void done(ParseException e) {
						if (e == null) {
							getActivity().setResult(Activity.RESULT_OK);
							getActivity().finish();
						} else {
							Toast.makeText(
									getActivity().getApplicationContext(),
									"Error saving: " + e.getMessage(),
									Toast.LENGTH_SHORT).show();
						}
					}

				});

			}
		});

		cancelButton = ((Button) v.findViewById(R.id.cancel_button));
		cancelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				getActivity().setResult(Activity.RESULT_CANCELED);
				getActivity().finish();
			}
		});

		// Until the user has taken a photo, hide the preview
		photoPreview = (ParseImageView) v.findViewById(R.id.meal_preview_image);
		photoPreview.setVisibility(View.INVISIBLE);
		
		return v;
	}
	
	public void startCamera() {
		Fragment cameraFragment = new CameraFragment();
		FragmentTransaction transaction = getActivity().getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragmentContainer, cameraFragment);
		transaction.addToBackStack("fragment_new_upload");
		transaction.commit();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		ParseFile photoFile = ((NewMealActivity) getActivity())
				.getCurrentMeal().getPhotoFile();
		if (photoFile != null) {
			photoPreview.setParseFile(photoFile);
			photoPreview.loadInBackground(new GetDataCallback() {
				@Override
				public void done(byte[] data, ParseException e) {
					photoPreview.setVisibility(View.VISIBLE);
				}
			});
		}
	}
}
