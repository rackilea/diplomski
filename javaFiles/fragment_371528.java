@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if( requestCode== REQUEST_IMAGE_CAPTURE) {
        try {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                iv.setImageBitmap(imageBitmap);
                image = encode(imageBitmap);//this line is added to encode
            }
        }

        catch (Exception e){ Toast.makeText(DoReport.this, e.toString(), Toast.LENGTH_LONG).show();}
    }
    else if (requestCode == PHOTO_FROM_MEMORY_REQUESTED && resultCode == RESULT_OK) {
        updateSelectedPicture(data.getData());
    }
}