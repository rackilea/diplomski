private class DownloadFileTask extends AsyncTask<URL, Integer, Long> {
 protected Long doInBackground(URL... urls) {
    Url url = urls[0];
    //connect to url here
    .......
    try {           
        InputStream myInput = urlconnect.getInputStream();
        BufferedInputStream buffinput = new BufferedInputStream(myInput);

        ByteArrayBuffer baf = new ByteArrayBuffer(capacity);
        int current = 0;
        while((current = buffinput.read()) != -1) {
            baf.append((byte) current);
            //here you can send data to onProgressUpdate
            publishProgress((int) (((float)baf.length()/ (float)sizefile) * 100));
        }
    File outputfile = new File(createRepertory(app, 0), Filename);
    FileOutputStream myOutPut = new FileOutputStream(outputfile);
    myOutPut.write(baf.toByteArray());
    ...
 }

 protected void onProgressUpdate(Integer... progress) {
     //here you can set progress bar in UI thread
     progressBarStatus = progress;
 }