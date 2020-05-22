private static volatile ThreadSafeLazySingleton instance;

private ThreadSafeLazySingleton(){}

public static synchronized ThreadSafeLazySingleton getInstance(){
    if(instance == null){
         instance = new ThreadSafeLazySingleton();
    }
    return instance;
}