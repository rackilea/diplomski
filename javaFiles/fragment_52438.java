class MyManager {

    Observable<Api> apiProvider;

    MyManager(Observable<Api> apiProvider){
       // cache so can be fetched several times
       this.apiProvider = apiProvider.cache();
    }
}