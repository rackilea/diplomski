Date today = new Date();

try {
    File myFile = new File(Environment.getExternalStorageDirectory(), "mysdfile.txt");            
    myFile.createNewFile();

    FileOutputStream fOut = new FileOutputStream(myFile);
    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
    SimpleDateFormat dF = new SimpleDateFormat("HHMMSS");
    StringBuilder current = new StringBuilder(dF.format(today));
    myOutWriter.append(current);
    myOutWriter.close();
    fOut.close();
} catch (IOException e) {
    e.printStackTrace();
}