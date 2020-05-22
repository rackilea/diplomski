Intent esFileManagerIntent = new Intent(Intent.ACTION_GET_CONTENT);
esFileManagerIntent.setPackage("com.estrongs.android.pop");
esFileManagerIntent.setType("image/*");

Intent chooserIntent = Intent.createChooser(pickIntent, "Select Image");
chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{takePicture, dropboxIntent, esFileManagerIntent});