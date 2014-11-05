package org.bicsi.canada2014.application;



import org.bicsi.canada2014.activities.MainActivity;

import com.parse.Parse;
import com.parse.PushService;

import android.app.Application;




public class BICSIApplication extends Application {
	  @Override
	  public void onCreate() {
	    // The following line triggers the initialization of ACRA

	    Parse.initialize(this, "H025T6dVCXIyDm0kVYZEyMjqap5K36iu0ZsgYVai", "7uI3KCMsxUBxkivTAg8WYXI82wJPqFzA3EvOKH72");
	    PushService.setDefaultPushCallback(this, MainActivity.class);
	    
	    super.onCreate();
	  }



}
