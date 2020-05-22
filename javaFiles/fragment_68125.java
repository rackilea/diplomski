private void pickImage(){
    Intent intentImageContent = new Intent(Intent.ACTION_PICK, 
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(intentImageContent, loadImageResults);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == loadImageResults) {
        if (resultCode == RESULT_OK && data != null) {
            Intent intent = new Intent(this, Main3Activity.class);
            intent.putExtra("pickImage", data.getData());
            startActivity(intent);
        }
    }
}