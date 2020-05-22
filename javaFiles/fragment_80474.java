String FILE_NAME = "file.txt";
try {
    FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
    PrintWriter writer = new PrintWriter( new OutputStreamWriter( fos ) );
    writer.println(someText.toString());
    writer.println(someOtherText.toString());
    writer.close();
} catch (Exception e) {
    e.printStackTrace();
}