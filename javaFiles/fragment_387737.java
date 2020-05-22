public class DetailActivity extends Activity
{
    String descriptionFinale = null,imageFinale = null,url;
    int position;
TextView description_,titre,date;
ImageView image_;
ArrayList<Article> feeds ;

WebView contentWebView;


ProgressDialog dialog;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail);

    feeds=new Arraylist<Article>;
    contentWebView= (WebView)findViewById(R.id.contentWebView);
    date=(TextView) findViewById(R.id.date);
    titre=(TextView) findViewById(R.id.titre);
    Bundle b = getIntent().getExtras();
    position=b.getInt("position");
    url=b.getString("url");
    AndroidSaxFeedParser feedParser= new AndroidSaxFeedParser(url);


    new MyFetchTask().execute();



}

public class MyFetchTask extends AsyncTask<Object, Object, Object>
{

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();

        dialog=ProgressDialog.show(DetailActivity.this, "", "Loading...");

    }


    @Override
    protected Object doInBackground(Object... params) {
        // TODO Auto-generated method stub

        feeds=feedParser.parse();

        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);

        dialod.dismiss();
        date.setText(feeds.get(position).getTitle());
        GetDescriptionWebView.getDescriptionImage(position, feeds,contentWebView);
        titre.setText("Postulé le: "+GetDateFormat.getDate(position, feeds));

    }

}

}