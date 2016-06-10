package ir.tapsell.cordova;

import ir.tapsell.tapsellvideosdk.developer.DeveloperInterface;
import ir.tapsell.tapsellvideosdk.developer.CheckCtaAvailabilityResponseHandler;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;

public class TapsellVideo extends CordovaPlugin {
	static CallbackContext callbackContextKeepCallback;
	static Activity mActivity = null;
	
	public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView){
		super.initialize(paramCordovaInterface, paramCordovaWebView);
	}
	
	public boolean execute(String action, JSONArray args, CallbackContext CallbackContext) throws JSONException {
	    if (action.equals("init")) {
			init(action, args, CallbackContext);
			return true;
	    }
	    if (action.equals("showVideo")) {
	    	showVideo(action, args, CallbackContext);
		    return true;
		}
	    return false;
	}
	
	public void init(String action, JSONArray args, CallbackContext CallbackContext) throws JSONException {
	    mActivity = cordova.getActivity();
	    callbackContextKeepCallback = CallbackContext;
	    final String Key = args.getString(0);
	    DeveloperInterface.getInstance(mActivity).init(Key, mActivity);
	}

	public void showVideo(String action, JSONArray args, CallbackContext CallbackContext) throws JSONException {
	    mActivity = cordova.getActivity();
	    callbackContextKeepCallback = CallbackContext;
	    DeveloperInterface.getInstance(mActivity).showNewVideo(mActivity, 1, null, null);
	}
	
	public void onPause(boolean paramBoolean) {
	    super.onPause(paramBoolean);
	}

	public void onResume(boolean paramBoolean) {
	    super.onResume(paramBoolean);
	}

	public void onDestroy() {
	    super.onDestroy();
	}
}