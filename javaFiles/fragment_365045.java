public class MyListActivity extends Activity {  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        Log.d("Creating options menu", "True");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("Preparing options menu", "True");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
            return(true);

            case R.id.revert:
            return(true);
        }

        return(super.onOptionsItemSelected(item));
    }
}