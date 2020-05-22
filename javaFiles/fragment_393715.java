public void copyDBToSDCard() {
    try {
        InputStream myInput = new FileInputStream("/data/data/com.myproject/databases/"+DATABASE_NAME);

        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/"+DATABASE_NAME);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.i("FO","File creation failed for " + file);
            }
        }

        OutputStream myOutput = new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/"+DATABASE_NAME);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
        Log.i("FO","copied");

    } catch (Exception e) {
        Log.i("FO","exception="+e);
    }


}