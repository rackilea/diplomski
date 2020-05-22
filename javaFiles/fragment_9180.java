public class MainActivity extends Activity {

        Button dadclink;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            addListenerOnButton();
        }

        public void addListenerOnButton() {
            dadclink = (Button) findViewById(R.id.dadclink);

            dadclink.setOnClickListener(new OnClickListener() {

                @SuppressWarnings("unused")
                public Intent newInstagramProfileIntent(PackageManager pm, String url) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.parse("http://instagram.com/mzcoco2you");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } 
            });
       }
   }