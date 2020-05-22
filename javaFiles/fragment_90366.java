//Create proper background thread pool. Not best but just for solution
new Thread(new Runnable() {
  @Override
  public void run() {

   // Moves the current Thread into the background
   android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

    HttpURLConnection httpURLConnection = null;
    byte[] buffer = new byte[2048];
    try {
      //Your http connection
      httpURLConnection = (HttpURLConnection) new URL("https://s3-ap-southeast-1.amazonaws.com/uploads-ap.hipchat.com/107225/1251522/SFSCjI8ZRB7FjV9/zvsd.zip").openConnection();

      //Change below path to Environment.getExternalStorageDirectory() or something of your
      // own by creating storage utils
      File outputFilePath = new File  ("/mnt/sdcard/Android/data/somedirectory/");

      ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(httpURLConnection.getInputStream()));
      ZipEntry zipEntry = zipInputStream.getNextEntry();

      int readLength;

      while(zipEntry != null){
        File newFile = new File(outputFilePath, zipEntry.getName());

        if (!zipEntry.isDirectory()) {
          FileOutputStream fos = new FileOutputStream(newFile);
          while ((readLength = zipInputStream.read(buffer)) > 0) {
            fos.write(buffer, 0, readLength);
          }
          fos.close();
        } else {
          newFile.mkdirs();
        }

        Log.i("zip file path = ", newFile.getPath());
        zipInputStream.closeEntry();
        zipEntry = zipInputStream.getNextEntry();
      }
      // Close Stream and disconnect HTTP connection. Move to finally
      zipInputStream.closeEntry();
      zipInputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      // Close Stream and disconnect HTTP connection.
      if (httpURLConnection != null) {
        httpURLConnection.disconnect();
      }
    }
  }
}).start();