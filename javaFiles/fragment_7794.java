public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView createChannel = findViewById(R.id.create_channel);

        createChannel.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                if (url!=null && url.contains("https://m.youtube.com/channel_creation_done")) {
                    view.setVisibility(View.INVISIBLE);
                    //Log.i("URLWEB", url);
                    Intent intent = new Intent();
                    intent.putExtra("created", "yes");
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        createChannel.loadUrl("https://m.youtube.com/create_channel?chromeless=1&next=/channel_creation_done");

    }
}