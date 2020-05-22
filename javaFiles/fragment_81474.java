public class UserDetailsViewModel extends ViewModel {
    private LiveData<User> userLiveData;

    public UserDetailsViewModel() {
        userLiveData = new UserLiveData();    
    }

    public void observeLiveDate(LifecycleOwner owner,
                              Observer<User> observer) {
        userLiveData.observe(owner, observer);
    }

    public void loadLiveData(Headers headers) {
        userLiveData = new UserLiveData(someArgs);
    }
}