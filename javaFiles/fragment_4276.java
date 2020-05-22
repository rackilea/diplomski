public class MyApplication extends Application{
    private String thing = null;

    public String getThing(){
        return thing;
    }

    public void setThing( String thing ){
        this.thing = thing;
    }
}

public class MyActivity extends Activity {
    private MyApplication app;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = ((MyApplication)getApplication());

        String thing = app.getThing();
    }
}