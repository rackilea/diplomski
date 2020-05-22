public class Main extends Activity{

    public static Main instance;
    public static String thestring;

    public class MyAsyncTask extends AsyncTask<Void,String,String>{

        static final String result = "text";
        Context context;


        public MyAsyncTask(Context m)
        {
            this.context = m;
        }

        @Override
        protected String doInBackground(Void... noArgs) {

            return result;
        }

        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);

        }

        public String getStr()
        {
            return result;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText et = (EditText)findViewById(R.id.editText1);
        Button btn = (Button)findViewById(R.id.button1);

        MyAsyncTask task = new MyAsyncTask(this);
        task.execute();

        thestring = task.getStr();

        instance = this;

        final Test t = new Test();

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {

                et.append(t.modifiedString());
            }
        });
    }


    public String pulledFromAsyncTask()
    {
        return thestring;
    }


    public static Main getInstance(){
        return instance;
    }
}