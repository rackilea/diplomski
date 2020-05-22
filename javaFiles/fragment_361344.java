@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // Or do you own task 
            return true;
        }
        return super.onOptionsItemSelected(item);
    }