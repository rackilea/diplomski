public abstract class MyAsyncTask<R, T> extends AsyncTask<Void, Void, R> {
    private Context context;
    private MyProgressDialog dialog;
    private OnAsyncTaskCompletedListener listener;
    private T search;
    private int task_id;

    public MyAsyncTask(int task_id, Context context,
            OnAsyncTaskCompletedListener listener) {
        super();

        this.context = context;
        this.listener = listener;
        this.task_id = task_id;
    }

    public MyAsyncTask(int task_id, Context context,
            OnAsyncTaskCompletedListener listener, T search) {
        this(task_id, context, listener);

        this.search = search;
    }

    protected void attach(Context context, OnAsyncTaskCompletedListener listener) {
        this.context = context;
        this.listener = listener;

        processCreateDialog();
    }

    protected void detach() {
        processDismissDialog();

        if (context != null) {
            context = null;
        }

        if (listener != null) {
            listener = null;
        }
    }

    @Override
    protected void onPostExecute(R result) {
        if (listener != null) {
            listener.onAsyncTaskCompleted(task_id, result);
        }

        detach();
    }

    @Override
    protected void onPreExecute() {
        processCreateDialog();
    }

    private void processCreateDialog() {
        if (context != null) {
            dialog = MyProgressDialog.show(context, null, null, true, false);
        }
    }

    private void processDismissDialog() {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception exception) {
            }

            dialog = null;
        }
    }
}