public class ExampleTask extends AsyncTask<String, Integer, String> {
    private ProgressDialog progressDlg;
    private Context context;
    private Handler progressHandler;

    public ExampleTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressHandler = new Handler();
    }

    @Override
    protected String doInBackground(String... params) {
        //to do
    }

    @Override
    protected void onPostExecute(String filePath) {
        if (progressDlg != null) {
            progressDlg.dismiss();
            progressDlg = null;
        }
    }

    @Override
    protected void onProgressUpdate(final Integer... values) {
        final int progress = values[0] / 1000;
        if (progressDlg == null) {
            progressHandler.post(new Runnable() {
                @Override
                public void run() {
                    final int max = values[1] / 1000;
                    progressDlg = new ProgressDialog(context);
                    progressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDlg.setMessage("Message");
                    progressDlg.setMax(max);
                    progressDlg.show();

                }
            });
        } else {
            progressDlg.setProgress(progress);
        }
    }
}