public class MainActivity extends Activity{

public static String rslt,thread;
SoapMiddleMan c;

EditText txtZIP;
TextView weather;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);     

    txtZIP = (EditText)findViewById(R.id.zipCode);
    weather = (TextView)findViewById(R.id.weather);

  }

public void sendMessage(View view)
{
    try{
            // condition for keeping the main thread asleep
            thread = "START";

            // create a new webservice caller thread
            c = new SoapMiddleMan();

            // join the new thread, start it and then select what webservice you want to access
            c.join();c.setZip(txtZIP.getText().toString()); c.start();

            // keep this thread asleep while the service thread is running
            while(thread=="START")
            {   
                try
                    {
                        Thread.sleep(10);
                    }
                catch(Exception e)
                    {
                        rslt="Failed2";
                    }
            }
        }

    catch(Exception e)
    {
        e.printStackTrace();
    }

    weather.setText(rslt);
}
}