public class AsynTaskTest extends AsyncTask<Void, Integer, Void> {
ProgressBar progressBar;
Context context;
int count = 1;
int update = 5;

public AsynTaskTest(Context context ,  ProgressBar progressBar){
    this.context = context;
    this.progressBar = progressBar;
}

@Override
protected Void doInBackground(Void... voids) {

    while(count <= 11){
        try {
            Thread.sleep(5000);
            int progress = (update*100)/60;
            publishProgress(progress);
            update += 5;
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    return null;
}

@Override
protected void onPreExecute() {
    super.onPreExecute();
}

@Override
protected void onPostExecute(Void aVoid) {
    progressBar.setVisibility(View.GONE);
}

@Override
protected void onProgressUpdate(Integer... values) {
    progressBar.setProgress(values[0]);
}
}