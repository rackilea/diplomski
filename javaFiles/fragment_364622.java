class WordRepo {
    private WordDao wordDao;

    WordRepo(Context applicationContext) {
        WordDb wordDb = WordDb.getInstance(applicationContext);
        wordDao = wordDb.wordDao();
    }

    void getAllWords(WordRepo.iGetWords listener) {
        try {
            Log.i("WordRepo", String.format("getAllWords() called from %s", Thread.currentThread().getName()));
            new GetAllWordsWithCallBackTask(wordDao, listener).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class GetAllWordsWithCallBackTask extends AsyncTask<Void, Void, List<Word>> {

        WordRepo.iGetWords listener;
        WordDao wordDao;

        GetAllWordsWithCallBackTask(WordDao wordDao, WordRepo.iGetWords listener) {
            this.listener = listener;
            this.wordDao = wordDao;
        }

        @Override
        protected List<Word> doInBackground(Void... voids) {

            Log.i("WordRepo", String.format("GetAllWordsWithCallBackTask.doInBackground() called from %s", Thread.currentThread().getName()));
            return wordDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Word> words) {
            Log.i("WordRepo", String.format("GetAllWordsWithCallBackTask.onPostExecute() called from %s", Thread.currentThread().getName()));

            listener.gotWords(words);
        }
    }

    public interface iGetWords {
        void gotWords(List<Word> words);
    }
}