public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_help:
                dispatchHelpIntent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void dispatchHelpIntent() {
        // Handle help options button
    }

}