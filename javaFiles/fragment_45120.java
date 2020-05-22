public class Common extends Application {

private Service mService; //Service Object from your class that extends service.
private Context mContext;

public Service getService(){
    return mService;
}
public void setService(Service service){
    mService = service;
}



@Override
public void onCreate() {
    super.onCreate();
    //Gets the context associated with the whole application
    mContext = getApplicationContext();
}
}


public class Service extends Service{

private Common mApp;
private Context mContext;


//Instantiate the Common Object from the singleton class within on create.
@Override
public void onCreate() {
    super.onCreate();
    mContext = getApplicationContext();

    mApp = (Common) getApplicationContext();
    mApp.setService(this);

    }

 }

  //Now to use it in your base Activity

public class BaseActivity extends AppCompatActivity{

private Common mApp;
private Service mService;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApp = (Common) mContext.getApplicationContext();

        //To use the service you would simply use:

        mService = mApp.getService()./*Some public method defined in your service*/;



    }


}