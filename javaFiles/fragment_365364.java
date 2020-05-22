private void copyDatabase() throws IOException {
    InputStream myInput = null;
    OutputStream myOutput = null;
    String outFileName = ourContext.getDatabasePath(DATABASE_NAME).getPath(); //<<<<<<<<<< CHANGED

    try {
        myInput = ourContext.getAssets().open(DATABASE_NAME);
        myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    } catch (IOException ie) {
        throw new Error("Copydatabase() error");
    }
}