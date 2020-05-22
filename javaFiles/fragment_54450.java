import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import android.util.Log;

import com.facebook.android.FacebookError;
import com.facebook.android.AsyncFacebookRunner.RequestListener;

public class FacebookPostListener implements RequestListener {
    private static final String TAG = "FacebookPostListener";

    @Override
    public void onComplete(final String response, final Object state) {
        Log.d(TAG, "Facebook published the post. Got response: " + response);
    }

    @Override
    public void onFacebookError(FacebookError e, final Object state) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onFileNotFoundException(FileNotFoundException e, final Object state) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onIOException(IOException e, final Object state) {
        Log.e(TAG, e.getMessage(), e);
    }

    @Override
    public void onMalformedURLException(MalformedURLException e, final Object state) {
        Log.e(TAG, e.getMessage(), e);
    }
}