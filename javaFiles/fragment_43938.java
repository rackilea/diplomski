public class Main {
public static final int NAME = 0;
public static final int CODE = 1;
public static final int PRICE = 2;
public static final int COLOR = 3;
public static final int TYPE = 4;
public static final int STOCK = 5;

public static void main(String[] args) throws IOException{
    ArrayList<Map<Integer, String>> csvData = loadCSVFile("C:\\path\\to\\file\\products.txt");

    //Print some of the data
    System.out.println("---------------------------");
    for(Map<Integer, String> record : csvData){
        printInfo(record);
    }
}

public static ArrayList<Map<Integer, String>> loadCSVFile(String path) throws IOException{
    ArrayList<Map<Integer, String>> csvData = new ArrayList<Map<Integer, String>>();

    BufferedReader csvFile = new BufferedReader(new FileReader(new File(path)));
    String line = "start";
    int count = 0;
    while((line = csvFile.readLine()) != null){
        if(count == 0){
            count++;
            continue;
        }

        HashMap<Integer, String> record = new HashMap<Integer, String>();
        String[] raw = line.split(",");
        Boolean store = true;
        for(int i=0;i<raw.length; i++){
            if(raw[i].equals("") || raw[i].equals(null))
            {
                store = false;
                break;
            }
            record.put(i, raw[i]);
        }

        if(store)
            csvData.add(record);
    }   
    csvFile.close();
    return csvData;
}

public static void printInfo(Map<Integer, String> record){
    System.out.println(record.get(CODE) + " : " + record.get(TYPE));
    System.out.println(record.get(NAME) + " : " + record.get(STOCK) + " : " + record.get(PRICE));
    System.out.println("---------------------------");
}

}