public class Main {

    public String[] readFromFile (String filePath) {

        ArrayList<String> yourList = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // read file content to yourList
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return yourList.toArray(new String[yourList.size()]);
    }
}