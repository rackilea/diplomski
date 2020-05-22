public static void loadScores() {
    File file = null;
    try{
        file = new File("scores.gz");
        if (!file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               System.out.println(line);
            }
            fileReader.close();
        } else {
            System.out.print("\n\nSorry, commander, your file name: " + filename + " does not exist.");
        }
    }
    catch(IOException e) {
        e.printStackTrace();
    }
}