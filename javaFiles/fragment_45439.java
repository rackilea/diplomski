private final static String FOLDER_NAME = "YourAppName/Image/";
 private Uri selectedImageUri = null;

public void startCamera() 
    {
        File photo = null;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) 
        {
            photo = new File(android.os.Environment.getExternalStorageDirectory(), FOLDER_NAME+File.separator+timeStamp+".png");
        } 
        else 
        {
            photo = new File(getCacheDir(), FOLDER_NAME+File.separator+timeStamp+".png");
        }    
        if (photo != null) 
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
            selectedImageUri = Uri.fromFile(photo);
            startActivityForResult(intent, CAPTURE_IMAGE_CALLBACK);
        }
    }