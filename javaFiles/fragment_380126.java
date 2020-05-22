public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == LOAD_IMAGE_RESULTS && resultCode == Activity.RESULT_OK && data != null) {
        Uri selectedImageURI = data.getData();
        String imageStringPath = FileUtils.getPath(activity, selectedImageURI);

        if (selectedImageURI != null && imageStringPath != null) {                
            //here you can do what ever you want
            //File imgFile = new File(imageStringPath);
            //...
        }
    }
}