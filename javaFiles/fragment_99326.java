private void copyDataBase() throws IOException {

    InputStream myInput = myContext.getAssets().open(DB_NAME);

    String outFileName = DB_PATH + DB_NAME;

    OutputStream myOutput = new FileOutputStream(outFileName);

    byte[] buffer = new byte[1024];
    int length;
    while ((length = myInput.read(buffer)) > 0) {
        myOutput.write(buffer, 0, length);
    }

    myOutput.flush();
    myOutput.close();
    myInput.close();
}