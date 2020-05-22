@Override
protected void onActivityResult(int reqCode, int resCode, Intent data) {
    if(resCode == RESULT_OK){
        if(reqCode == 1)
            imageView.setImageURI(data.getData());
            Bitmap bm=((BitmapDrawable)imageView.getDrawable()).getBitmap();
            saveImageFile(bm);
    }
}

    public String saveImageFile(Bitmap bitmap) {
            FileOutputStream out = null;
            String filename = getFilename();
            try {
                out = new FileOutputStream(filename);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return filename;
        }

        private String getFilename() {
            File file = new File(Environment.getExternalStorageDirectory()
                    .getPath(), "TestFolder");
            if (!file.exists()) {
                file.mkdirs();
            }
            String uriSting = (file.getAbsolutePath() + "/"
                    + System.currentTimeMillis() + ".jpg");
            return uriSting;
        }