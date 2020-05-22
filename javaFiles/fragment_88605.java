public class MyAsyncTaskimpl extends MyAsyncTask<Cursor, String> {

    public MyAsyncTaskimpl(int task_id, Context context,
            OnAsyncTaskCompletedListener listener, String search) {
        super(task_id, context, listener, search);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Cursor doInBackground(Void... params) {
        // TODO Auto-generated method stub
        return null;
    }

}