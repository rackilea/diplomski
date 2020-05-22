public class FileParser  {
 public static ArrayList<String> parseFile(String fileName){
  String csvFile = fileName;
  BufferedReader br = null;
 String line = "";
 final String DELIMITER = ",";
 ArrayList<String> data = new ArrayList<String>();

try {
    int counter = 0;
    int N = 10;
    br = new BufferedReader(new FileReader(csvFile));
    while ((line = br.readLine()) != null && counter < N) {
        if(counter >= 0){
            String dataRow = line;
            data.add(dataRow);
        }
        counter++;
    }

    for (String string : data) {
        string.split(DELIMITER);
        System.out.println(string);
    }

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
return data;