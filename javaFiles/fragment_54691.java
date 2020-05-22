public static  String parameterForURL = "";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    parameterForURL ="shakil,123";

    doorOpenButtonActionClass.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            new SendRequest().execute(parameterForURL);
            resultContainer="";
        }
    });
}

public class SendRequest extends AsyncTask<String, Void, String> {

    protected String doInBackground(String[] paramparameterForURL) {

        Log.v("Passed=",paramparameterForURL[0].toString());

        try{
            Log.v("Passed=",paramparameterForURL[0].toString());
            //String serv_url="http://www.eurekabd.com/shakil/home.php"+paramparameterForURL[0].toString();

            serv_url="http://192.168.0.109/shakil/shakil.php/?"+paramparameterForURL[0];
            //serv_url += paramparameterForURL;
            Log.e("Server Url",serv_url.toString());
            URL url = new URL(serv_url);