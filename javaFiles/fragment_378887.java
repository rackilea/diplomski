public void performCrop(boolean cameraShot){
            try {
                Intent cropIntent = new Intent("com.android.camera.action.CROP");
                //indicate image type and Uri
                //cropIntent.setDataAndType(picUri, "image");
                cropIntent.setDataAndType(picUriCar, "image/*");
                //set crop properties
                cropIntent.putExtra("crop", "true");
                //indicate aspect of desired crop
                cropIntent.putExtra("aspectX", 2);
                cropIntent.putExtra("aspectY", 1);
                //indicate output X and Y
                cropIntent.putExtra("outputX", 1024);
                cropIntent.putExtra("outputY", 512);
                cropIntent.putExtra("scale", true);
                cropIntent.putExtra("return-data", false);

                Uri uri;
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N || !cameraShot) {
                    uri = Uri.fromFile(croppedFileCar);
                }else{
                    String authority = "com.company.example.provider";
                    uri = FileProvider.getUriForFile(
                            MainActivity.this,
                            authority,
                            croppedFileCar);
                    cropIntent.setClipData(ClipData.newRawUri( "", uri ) );
                    cropIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }