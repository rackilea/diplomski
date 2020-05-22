private static final int TAKE_PHOTO_CODE = 1;
public void takePhoto(View view) {
    File file = new File(Environment.getExternalStorageDirectory(), "fname_" +
            String.valueOf(System.currentTimeMillis()) + ".jpg");
    Uri outputFileUri = Uri.fromFile(file);
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    cameraIntent.putExtra("pic_path", file.getAbsolutePath());
    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
    startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case TAKE_PHOTO_CODE:
            if(resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                String path = data.getExtras().getString("pic_path");
                pathlist.add(path);
                adapter.notifyDataSetChanged();
            }
            break;
    }
}