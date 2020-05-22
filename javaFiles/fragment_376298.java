public class Example extends Activity{

Spinner spDownloadFrom;
private ArrayAdapter<CharSequence> spinnerArrayAdapter;
String url[]= {"www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt",
        "www.abc.com/download/a.txt"
        };
String links[]= {"Server 1",
        "Server 2",
        "Server 3",
        "Server 4",
        "Server 5",
        "Server 6",
        "Server 7",
        };
public void onCreate(Bundle savedInstanceState )
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    spDownloadFrom=(Spinner)findViewById(R.id.addQuotation_spinnerProduct);

    spinnerArrayAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, links);
    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spDownloadFrom.setAdapter(spinnerArrayAdapter);

    spDownloadFrom.setOnItemSelectedListener(new SpinnerListener(spDownloadFrom));
}
public class SpinnerListener implements OnItemSelectedListener
{
    Spinner sp;
    public SpinnerListener(View v)
    {
        sp=(Spinner)findViewById(v.getId());
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View v, int arg2,
            long arg3) {
        //Call to download class
            new DownloadFile().equals(url[arg2].toString());


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
class DownloadFile extends AsyncTask<String, String, String> { //put your download code

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... aurl) {



        return null;

    }
    protected void onProgressUpdate(String... progress) {
         Log.d("Downloading",progress[0]);

    }

    @Override
    protected void onPostExecute(String unused) {
    }
}
 }