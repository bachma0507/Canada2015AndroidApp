package org.bicsi.canada2014.application;



import org.bicsi.canada2014.Meal;
import org.bicsi.canada2014.activities.MainActivity;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;



import android.app.Application;



public class BICSIApplication extends Application {
	  @Override
	  public void onCreate() {
	    // The following line triggers the initialization of ACRA
		  
		  ParseObject.registerSubclass(Meal.class);

	    Parse.initialize(this, "Ag86hjT9oVi1ok806lvlVyGgdnh1Mi7J2cxcyBSA", "Tkx1x796SC7ChYdJRkImEmvJHh9UkK4YbWoadfRo");
	    PushService.setDefaultPushCallback(this, MainActivity.class);
	    
	    super.onCreate();
	  }



}
