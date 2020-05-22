public class MyActivity extends AppCompatActivity { 
   private final String FRAGMENT_TAG = "myFragment";

   private static class FtpDownload extends AsyncTask<String, String, String> {

    //rest of your FtpDownload class

    @Override
    protected void onPostExecute(String output) {

        GuidanceActivity activity = activityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG );
        /* or 
        MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment );
        if your fragment is in an xml layout */

        fragment.updateTextView(Html.fromHtml(activity.contents));
    }
  }

}