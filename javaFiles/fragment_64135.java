public class MainTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent in = new Intent(MainTestActivity.this, TestActivityB.class);
                startActivityForResult(in, 101);
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_test, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Got Intent", Toast.LENGTH_SHORT).show();
    }

}