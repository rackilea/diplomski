public class AddFriendViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private IdCallback callback;

    public AddFriendViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    void addFriend(final FriendEntity friendEntity,IdCallback callback) {
        AddAsyncTask myTask = new AddAsyncTask(appDatabase);
        this.callback = callback; //< assign
        myTask.execute(friendEntity);
    }

    private static class AddAsyncTask extends AsyncTask<FriendEntity, Void, Long> {

        private AppDatabase db;

        AddAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Long doInBackground(final FriendEntity... params) {
            return db.friendDao().insert(params[0]);
        }

        @Override
        protected void onPostExecute(Long insertedId) {
            callback.onFriendInserted(insertedId);
        }
    }
}