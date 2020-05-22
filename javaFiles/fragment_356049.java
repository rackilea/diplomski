public class MainActivity extends ListActivity implements PHPRequestRetriever.Listener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        PHPRequestRetriever retriever = new PHPRequestRetriever(this);
        ArrayList<NameValuePair> args = new ArrayList<NameValuePair>();
        // Set your args here
        retriever.execute("http://example.com/phpscript.php", args);

    }

    @Override
    public void handlePHPRequestFinished(String data) {
        // Handle the result
    }

}