submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent returnIntent = new Intent();
        if(selectedImage!=null) {
            returnIntent.putExtra("img_uri", selectedImage.toString());
        } else {
            returnIntent.putExtra("img_uri", Uri.parse("android.resource://your.package.name/mipmap/no_image").toString());
        }
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
});