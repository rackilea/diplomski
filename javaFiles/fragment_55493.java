public class MyService extends Service {
    // Binder given to clients 
    private final IBinder binder = new LocalBinder();
    // Registered callbacks 
    private ServiceCallbacks serviceCallbacks;


    // Class used for the client Binder. 
    public class LocalBinder extends Binder {
        MyService getService() { 
            // Return this instance of MyService so clients can call public methods 
            return MyService.this;
        } 
    } 

    @Override 
    public IBinder onBind(Intent intent) {
        return binder;
    } 

    public void setCallbacks(ServiceCallbacks callbacks) {
        serviceCallbacks = callbacks;
    } 
}