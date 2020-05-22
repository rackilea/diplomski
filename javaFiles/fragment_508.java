public class MyMV extends AndroidViewModel {
    private MutableLiveData<User> userLiveData = new MutableLiveData();

    //main logic for getting data from a db
    public void getUser(long userId) {
       new Thread(()-> {
          //do not use the '.setValue()', a post method will send a result to observers immediately
          userLiveData.postValue(new User(dao.getUserById(userId));
       }).start();
    }

    //UserLiveData getter
    public LiveData<User> getUserData() {
        return userLiveData;
    }
}