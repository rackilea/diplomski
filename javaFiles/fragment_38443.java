interface MyDataStore {
   ... getPojo()
}

public class MyRepository implements MyDataStore {
   ...
}

public MyViewModel(MyDataStore dataStore) {
        this.dataStore = dataStore;
        this.pojo = new MutableLiveData<>();
}