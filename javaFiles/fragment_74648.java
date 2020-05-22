public static ArrayList<String> searchInFile(String word) {


    ArrayList<String> result = new ArrayList<String>();
    FileReader fileReader = null;
    try {
        fileReader = new FileReader(new File("input.txt"));
    } catch (FileNotFoundException e1) {
        System.err.println("File input.txt not found!");
        e1.printStackTrace();
    }

    BufferedReader br = new BufferedReader(file);
    String line;
    try {
        while ((line = br.readLine()) != null) {
          if (line.contains(word)) {
              result.Add(word);
           }
        }

    } catch (IOException e) {
        System.err.println("Error when processing the file!");
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                System.err.println("Unexpected error");
                e.printStackTrace();
            }
        }

    }
    return result;
}