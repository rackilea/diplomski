File sd = Environment.getExternalStorageDirectory();
String destinationImagePath = sd + AppConstant.PHOTO_ALBUM;
File imagePath = new File(destinationImagePath);
File source = new File(sourcePath);
String fileName = source.getName();
File destination = new File(destinationImagePath + fileName);
   if (!imagePath.exists()) {
       imagePath.mkdirs();
       try {
            copy(source, destination);
            Toast.makeText(getApplicationContext(), "Success! File was copy from " + sourcePath + " to " + destinationImagePath, Toast.LENGTH_LONG).show();
       } catch (Exception e) {
            Log.e("COPY IMAGE ERROR", e.toString());
       }
   } else if(destination.exists() && !destination.isDirectory()){
       Toast.makeText(getApplicationContext(), "Image is already on your image folder", Toast.LENGTH_LONG).show();
   }