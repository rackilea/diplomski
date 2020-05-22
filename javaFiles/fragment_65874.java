import android.os.AsyncTask;

import java.io.IOException;

public class Search extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... params) {
        try {
            videoFileList = YoutubeConnector.search();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String a){
        VideoListActivity.context.updateAdapter();
    }
}