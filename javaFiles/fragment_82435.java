HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    if(ISSUE_DOWNLOAD_STATUS.intValue()==ECMConstant.ECM_DOWNLOADING){
        File file=new File(DESTINATION_PATH);
        if(file.exists()){
             downloaded = (int) file.length();
             connection.setRequestProperty("Range", "bytes="+(file.length())+"-");
        }
    }else{
        connection.setRequestProperty("Range", "bytes=" + downloaded + "-");
    }
    connection.setDoInput(true);
    connection.setDoOutput(true);
    progressBar.setMax(connection.getContentLength());
     in = new BufferedInputStream(connection.getInputStream());
     fos=(downloaded==0)? new FileOutputStream(DESTINATION_PATH): new FileOutputStream(DESTINATION_PATH,true);
     bout = new BufferedOutputStream(fos, 1024);
    byte[] data = new byte[1024];
    int x = 0;
    while ((x = in.read(data, 0, 1024)) >= 0) {
        bout.write(data, 0, x);
         downloaded += x;
         progressBar.setProgress(downloaded);
    }