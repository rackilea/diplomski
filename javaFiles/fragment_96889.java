@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                AlertDialog alertDialog = new AlertDialog.Builder(ActivityName.this).create(); // You can use activity context directly.
                alertDialog.setTitle("Item 1");         
                alertDialog.setMessage("This is Item 1");           
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }