import android.os.Bundle;
import android.util.Log;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class FacebookAuthListener implements DialogListener {

    private static final String TAG = FacebookAuthListener.class.getSimpleName();

    @Override
    public void onFacebookError(FacebookError e) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onError(DialogError e) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onComplete(Bundle values) {
    }

    @Override
    public void onCancel() {
        // Do nothing
    }
}