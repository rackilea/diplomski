private void requestPermission(String permission){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        if (ContextCompat.checkSelfPermission(BookListActivity.this, 
                Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(BookListActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_READ_CONTACTS);

        }
    }
}