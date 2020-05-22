import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class MyTask extends AsyncTask<Void, Void, Void> {

private final WeakReference<MyActivity> weakReferenceActivity;

public MyTask(@NonNull MyActivity activity) {
    this.weakReferenceActivity = new WeakReference<>(activity);
}

@Nullable
public MyActivity getActivity() {
    MyActivity activity = weakReferenceActivity.get();
    if (activity.isDestroyed()) {
        return null;
    }
    return activity;
}

@Override
protected void onPreExecute() {
    MyActivity activity = getActivity();
    if (activity != null) {
        activity.showProgressDialog();
    }
}

@Override
protected Void doInBackground(Void... voids) {
    [do something]
    return null;
}

@Override
protected void onPostExecute(Void nothing) {
    MyActivity activity = getActivity();
    if (activity != null) {
        activity.hide();
    }
}
}