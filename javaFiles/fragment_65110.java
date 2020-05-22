String filePath= Environment.getExternalStorageDirectory()+"/myPic.jpeg";
File file=new File(filePath);
Uri output=Uri.fromFile(file);
Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, output);
startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);