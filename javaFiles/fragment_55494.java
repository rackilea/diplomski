public class MyActivity extends Activity implements ServiceCallbacks {
    private MyService service;
    private boolean bound = false;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ......
    } 

    @Override 
    protected void onStart() { 
        super.onStart(); 
        // bind to Service 
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    } 

    @Override 
    protected void onStop() { 
        super.onStop(); 
        // Unbind from service 
        if (bound) {
            service.setCallbacks(null); // unregister
            unbindService(serviceConnection);
            bound = false;
        } 
    } 

    /** Callbacks for service binding, passed to bindService() */ 
    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override 
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            // cast the IBinder and get MyService instance 
            LocalBinder binder = (LocalBinder) service;
            service = binder.getService();
            bound = true;
            service.setCallbacks(this); // register
        } 

        @Override 
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        } 
    }; 

    /* Defined by ServiceCallbacks interface */ 
    @Override 
    public void Showtoast(String message) { 
         Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    } 
}