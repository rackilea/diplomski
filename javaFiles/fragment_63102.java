public class main extends Activity {

    private WebView webv;
    private SeekBar seitenSwitcher;
    private String[] websites = { "http://www.google.de", "http://stackoverflow.com", "http://www.android.com" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webv = (WebView)findViewById(R.id.Viewing);
        webv.getSettings().setJavaScriptEnabled(true);
        webv.loadUrl(websites[0]);

        seitenSwitcher = (SeekBar) findViewById(R.id.seitenSwitcher);
        seitenSwitcher.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= 0 && progress < websites.length) {
                    webv.loadUrl(websites[progress]);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}