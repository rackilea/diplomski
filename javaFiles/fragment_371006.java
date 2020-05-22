Handler handler=new Handler();
    handler.postDelayed(new Runnable() {

      @Override
      public void run() {

          InputStream first =  getResources().openRawResource(R.raw.file101);
          InputStream second = getResources().openRawResource(R.raw.file103);

          String filepath = Environment.getExternalStorageDirectory().getPath();
          File file = new File(filepath, "myapp");
          mergeSongs(new File(file.getAbsoluteFile()+"/mergedFile.mp3"), new InputStream[] {first, second});

      }
  },2000);


private void mergeSongs(File mergedFile,InputStream...mp3InputStream){

    try {
        InputStream fis1 = mp3InputStream[0]; //Error is at this line
        InputStream fis2 = mp3InputStream[1];
        Toast.makeText(MainActivity.this, "Something", Toast.LENGTH_LONG).show();
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);

        if(!mergedFile.exists()){
            mergedFile.createNewFile();}

        FileOutputStream fos = new FileOutputStream(mergedFile);

        int temp;

         while ((temp = sis.read())!= -1){

                fos.write((byte)temp);

            }

         fis1.close();
         fis2.close();
         sis.close();
         fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

}