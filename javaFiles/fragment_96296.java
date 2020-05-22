public String readFromFile(String path) {

   //Get the text file
    File file = new File(path);
    //Read text from file
    StringBuilder text = new StringBuilder();

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        br.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    //This is the text from the file
    return text.toString();
}