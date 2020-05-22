String FILE_NAME = "file.txt";
try {
    FileInputStream fis = openFileInput(FILE_NAME, Context.MODE_PRIVATE);
    BufferedReader reader = new BufferedReader( new InputStreamReader( fis ) );
    String line;
    while ( (line = reader.readLine()) != null ) {
        System.out.println("Read line: " + line);
    } 
    reader.close();
} catch (Exception e) {
    e.printStackTrace();
}