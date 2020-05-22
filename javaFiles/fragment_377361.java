public class MovieViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;


    public MovieViewModelFactory(Application application, String param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MovieViewModel(mApplication, mParam);
    }
}