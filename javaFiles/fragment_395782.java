public Runnable getS3UploadTask () {
   return new Runnable() {
       public void run() {
           uploadToS3();
       }
   };
}