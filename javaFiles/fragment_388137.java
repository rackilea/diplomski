public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.locationButton:
                Intent locationIntent = new Intent(this, LocationActivity.class);
                startActivity(locationIntent);
                return true;
            case R.id.diningButton:
                Intent diningIntent = new Intent(this, DiningActivity.class);
                startActivity(diningIntent);
                return true;

            case R.id.topXXVButton:
                Intent topIntent = new Intent(this, DiningActivity.class);
                startActivity(topIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}