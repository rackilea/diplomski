public static void readSplitWrite(String pathToFile){
    //To recognize how are your sentences : between 1 and 25 digit, then some spaces, and then what you want 
    Pattern patt = Pattern.compile("([0-9]{1,25})\\s*(.*)");
    try {
        //Read over all the lines of your file
        for(String line : Files.readAllLines(Paths.get(pathToFile),Charset.forName("UTF-8"))){
            //Catch the different parts of the string (group(0) is the hole sentence, group(1) is inside first (), group(2) is inside second ()
            Matcher m = patt.matcher(line);
            if(m.find()){       
                //Open a file, in UTF-8 encoding (to be able to read Arabic character, as name the ID
                Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(m.group(1)+".txt"), "UTF-8"));
                try {
                    //write the content into
                    out.write(m.group(2));
                }catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    out.close();
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    //Just the name if the file is in the folder, if not write absolute path
    String pathToFile = "Text.txt";
    readSplitWrite(pathToFile);
}