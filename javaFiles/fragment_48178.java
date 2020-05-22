private final Object lockObject = new Object();
...

public Car getCar(int id){
   synchronized (lock) {
      ...
   }
}
public Car findCarInCache(int id){
   synchronized (lock) {
      ...
   }
}
public Car createCarWithId(int id){
   synchronized (lock) {
      ...
   }
}