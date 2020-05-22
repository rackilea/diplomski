Uri imageUri;
final int TAKE_PICTURE = 115;

public void capturePhoto(View view) {
    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
    File photoFile = new File(Environment.getExternalStorageDirectory(),  "Photo.png");
    intent.putExtra(MediaStore.EXTRA_OUTPUT,
            Uri.fromFile(photoFile));
    imageUri = Uri.fromFile(photoFile);
    startActivityForResult(intent, TAKE_PICTURE);
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case TAKE_PICTURE:
            if (resultCode == Activity.RESULT_OK) {
                Uri selectedImageUri = imageUri;
                //Do what ever you want
        }
    }
}