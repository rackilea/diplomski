@Override
protected void onCreate(Bundle savedInstanceState) {
    ........
    ........

    AsyncParameters param = new AsyncParameters(URL, directory);
    DownloadAsync Downloader = new DownloadAsync();
    Downloader.execute(param);

    .......
    .......
}

public class DownloadAsync extends AsyncTask<AsyncParameters, Void, Void> {
    .......

    @Override
    protected void onPostExecute() {
        pDialog.dismiss();
        showPdf();
    }
}