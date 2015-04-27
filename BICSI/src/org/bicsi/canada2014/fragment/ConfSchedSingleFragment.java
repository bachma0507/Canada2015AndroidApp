package org.bicsi.canada2014.fragment;

import org.bicsi.canada2014.activities.MainActivity;
import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;
import org.bicsi.canada2015.R;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ConfSchedSingleFragment extends Fragment  {
	
	private NavigateToTabFragmentListener mCallback;
	
	public String newFunctioncd;
	
	TextView title;
	TextView date;
	TextView start;
	TextView end;
	TextView desc;
	TextView location;
	TextView trainer1fname;
	TextView trainer1lname;
	TextView trainer2fname;
	TextView trainer2lname;
	TextView trainer3fname;
	TextView trainer3lname;
	TextView trainer4fname;
	TextView trainer4lname;
	TextView trainer5fname;
	TextView trainer5lname;
	TextView trainer6fname;
	TextView trainer6lname;
	TextView speakerslabel;
	Button surveybutton;
	
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
		final View v = inflater.inflate(R.layout.fragment_confschedule_single, container, false);
		
		title = (TextView)v.findViewById(R.id.functiontitle);
		date = (TextView)v.findViewById(R.id.functiondate);
		start = (TextView)v.findViewById(R.id.functionstarttimestr);
		end = (TextView)v.findViewById(R.id.functionendtimestr);
		desc = (TextView)v.findViewById(R.id.functiondecsription);
		location = (TextView)v.findViewById(R.id.functionlocation);
		trainer1fname = (TextView)v.findViewById(R.id.trainer1fname);
		trainer1lname = (TextView)v.findViewById(R.id.trainer1lname);
		trainer2fname = (TextView)v.findViewById(R.id.trainer2fname);
		trainer2lname = (TextView)v.findViewById(R.id.trainer2lname);
		trainer3fname = (TextView)v.findViewById(R.id.trainer3fname);
		trainer3lname = (TextView)v.findViewById(R.id.trainer3lname);
		trainer4fname = (TextView)v.findViewById(R.id.trainer4fname);
		trainer4lname = (TextView)v.findViewById(R.id.trainer4lname);
		trainer5fname = (TextView)v.findViewById(R.id.trainer5fname);
		trainer5lname = (TextView)v.findViewById(R.id.trainer5lname);
		trainer6fname = (TextView)v.findViewById(R.id.trainer6fname);
		trainer6lname = (TextView)v.findViewById(R.id.trainer6lname);
		speakerslabel = (TextView)v.findViewById(R.id.speakers_label);
		surveybutton = (Button)v.findViewById(R.id.survey_button);
		
		
		Bundle bundle = getArguments();
				if(bundle != null){
				
				newFunctioncd = bundle.getString("_id");
				
				if(newFunctioncd.contains("CONCSES") || newFunctioncd.contains("PRECON") || newFunctioncd.contains("GS_TUES") || newFunctioncd.contains("GS_THURS") == true){
					speakerslabel.setVisibility(View.VISIBLE);
					surveybutton.setVisibility(View.VISIBLE);
				}
				else{
					speakerslabel.setVisibility(View.GONE);
					surveybutton.setVisibility(View.GONE);
				}
				
				String ftitle = bundle.getString("functiontitle");
				title.setText(ftitle);
				
				String fdate = bundle.getString("fucntioindate");
				date.setText(fdate);
				
				String fstart = bundle.getString("functionStartTimeStr");
				start.setText(fstart);
				
				String fend = bundle.getString("functionEndTimeStr");
				end.setText(fend);
				
				String fdesc = bundle.getString("functiondescription");
				desc.setText(fdesc);
				
				String floc = bundle.getString("LOCATIONNAME");
				location.setText(floc);
				
				String t1fname = bundle.getString("trainer1firstname");
				trainer1fname.setText(t1fname);
				
				String t1lname = bundle.getString("trainer1lastname");
				trainer1lname.setText(t1lname);
				
				String t2fname = bundle.getString("trainer2firstname");
				trainer2fname.setText(t2fname);
				
				String t2lname = bundle.getString("trainer2lastname");
				trainer2lname.setText(t2lname);
				
				if(t2fname.isEmpty() == true){
					trainer2fname.setVisibility(View.GONE);
					trainer2lname.setVisibility(View.GONE);
				}
				
				String t3lname = bundle.getString("trainer3lastname");
				trainer3lname.setText(t3lname);
				
				String t3fname = bundle.getString("trainer3firstname");
				trainer3fname.setText(t3fname);
				
				if(t3fname.isEmpty() == true){
					trainer3fname.setVisibility(View.GONE);
					trainer3lname.setVisibility(View.GONE);
				}
				
				String t4lname = bundle.getString("trainer4lastname");
				trainer4lname.setText(t4lname);
				
				String t4fname = bundle.getString("trainer4firstname");
				trainer4fname.setText(t4fname);
				
				if(t4fname.isEmpty() == true){
					trainer4fname.setVisibility(View.GONE);
					trainer4lname.setVisibility(View.GONE);
				}
				
				String t5lname = bundle.getString("trainer5lastname");
				trainer5lname.setText(t5lname);
				
				String t5fname = bundle.getString("trainer5firstname");
				trainer5fname.setText(t5fname);
				
				if(t5fname.isEmpty() == true){
					trainer5fname.setVisibility(View.GONE);
					trainer5lname.setVisibility(View.GONE);
				}
				
				String t6lname = bundle.getString("trainer6lastname");
				trainer6lname.setText(t6lname);
				
				String t6fname = bundle.getString("trainer6firstname");
				trainer6fname.setText(t6fname);
				
				if(t6fname.isEmpty() == true){
					trainer6fname.setVisibility(View.GONE);
					trainer6lname.setVisibility(View.GONE);
				}
				
				
				
				surveybutton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						String urlEndStr = newFunctioncd.replace("'", "");
						
						Uri uri = Uri.parse("https://www.research.net/s/" + urlEndStr);
						Intent browserIntent = new Intent(Intent.ACTION_VIEW);
						browserIntent.setDataAndType(uri, "text/html");
						browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
						getActivity().startActivity(browserIntent);
						
						/*Intent internetIntent = new Intent(Intent.ACTION_VIEW,
								Uri.parse("https://www.research.net/s/" + urlEndStr));
								internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
								internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								getActivity().startActivity(internetIntent);*/
								
				
						
						/*WebViewActivity myWebViewFragment = new WebViewActivity();
						
						Bundle bundle = new Bundle();
						
						bundle.putString("urlEndStr", urlEndStr);
						
						myWebViewFragment.setArguments(bundle);

						mCallback.navigateToTabFragment(myWebViewFragment, null);*/
						
						//openInternalWebview("https://www.research.net/s/" + urlEndStr);
						//System.out.println("https://www.research.net/s/" + urlEndStr);
					}
				});
				
				}
				
				return v;
	}
	
	/*private void openInternalWebview(CharSequence urlToOpen) {
		if (urlToOpen == null) {
			return;
		}
		String urlString = urlToOpen.toString();
		((MainActivity)getActivity()).mWebViewURL = urlString;
		mCallback.navigateToTabFragment(newFragment, null);
	}

	@Override
	public void onResume() {
		super.onResume();
		((MainActivity)getActivity()).updateTracker("Home Tab");
	}*/
	
	@Override
	public void onResume() {
		super.onResume();
		((MainActivity)getActivity()).updateTracker("Home Tab");
	}
	
}
