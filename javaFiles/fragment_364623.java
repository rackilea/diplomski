public class MainViewModel extends AndroidViewModel {

    MutableLiveData<List<Word>> wordList = new MutableLiveData<>();
    private static final String TAG = "MainViewModel";

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    void getAllWords() {

        Log.i(TAG, String.format("getAllWords() called from %s", Thread.currentThread().getName()));
        WordRepo repo = new WordRepo(getApplication());

        repo.getAllWords(new WordRepo.iGetWords() {
            @Override
            public void gotWords(List<Word> words) {
                wordList.setValue(words);
            }
        });
    }
}