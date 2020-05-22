@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        /*camera preview*/

        if (resultCode != RESULT_CANCELED) {


            if (requestCode == 0) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                previewView.setImageBitmap(bp);
            }
        /*gallery preview*/
            else {

                Uri uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    Log.d(TAG, String.valueOf(bitmap));


                    ImageView previewView = (ImageView) findViewById(R.id.imgPostIssue);
                    previewView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }