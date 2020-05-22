public class YourClass {

//in init method or constructor 
ExecutorService executor = Executors....;// choose from newCachedThreadPool() or newFixedThreadPool(int nThreads) or some custom option


int clientNumber = 0;
ServerSocket listener = new ServerSocket(port);
while(true) {

    executor.execute(new GPSService(listener.accept(), client++, serverUrl));

}