public class SampleActivity extends Activity {

    //define callback interface
    interface MyCallbackInterface {

        void onDownloadFinished(String result);
    }

    //your method slightly modified to take callback into account 
    public void downloadUrl(String stringUrl, MyCallbackInterface callback) {
        new DownloadWebpageTask(callback).execute(stringUrl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //example to modified downloadUrl method
        downloadUrl("http://google.com", new MyCallbackInterface() {

            @Override
            public void onDownloadFinished(String result) {
                // Do something when download finished
            }
        });
    }

    //your async task class
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        final MyCallbackInterface callback;

        DownloadWebpageTask(MyCallbackInterface callback) {
            this.callback = callback;
        }

        @Override
        protected void onPostExecute(String result) {
            callback.onDownloadFinished(result);
        }

        //except for this leave your code for this class untouched...
    }
}