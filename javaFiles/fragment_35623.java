String image2Text(String imagePath)
  {
  dataPath= Environment.getExternalStorageDirectory().toString() + "/Android/data/" + appContext.getPackageName() +  "/"; 
    File tessdata = new File(dataPath); 
   if (!tessdata.exists() || !tessdata.isDirectory())
   {
       throw new IllegalArgumentException("Data path must contain subfolder tessdata!");   
} 
     Bitmap image= BitmapFactory.decodeFile(imagePath);
  TessBaseAPI baseApi = new TessBaseAPI();
  baseApi.init(dataPath, "eng"); 

baseApi.setImage(image);
      String recognizedText = baseApi.getUTF8Text();
      baseApi.end();


      return recognizedText;
  }