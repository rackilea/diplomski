public class HeadlessProgressFragment extends Fragment {

private ProgressListener mProgressListener;
private AsyncTask<Void, Integer, Void> mProgressTask;

public interface ProgressListener {
    void updateProgress(int progress);
}

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
}

public void setProgressListener(Context context) {
    mProgressListener = (ProgressListener) context;
}

public void startProgress(final int size) {
    if (mProgressTask == null || mProgressTask.getStatus() != AsyncTask.Status.RUNNING || mProgressTask.getStatus() == AsyncTask.Status.FINISHED) {
            mProgressTask = new AsyncTask<Void, Integer, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    for (int index = 0; index < size; index++) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            publishProgress(index + 1);
                        }
                    }
                    return null;
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
                    super.onProgressUpdate(values);
                    if (mProgressListener != null) {
                        mProgressListener.updateProgress(values[0]);
                    }
                }
            };
            mProgressTask.execute();
        }
    }
}