public class ReadAndParse {

    public Map<String, ArrayList<Integer>> data = new TreeMap<String, ArrayList<Integer>>();

     public ReadAndParse() {
        try {
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                String line = br.readLine();
                if (line == null)    break;

                else if (line.matches("\\\\#\\s[a-zA-Z]")){
                    String key = line.split("\\s")[1];
                    line = br.readLine();

                    ArrayList<Integer> value=  computeLine(line);

                    System.out.println("putting key : " + key + " value : " + value);
                    data.put(key, value);
                }
                else if (line.matches("\\\\\\#\\s(\\|[a-zA-Z]\\|,?\\s?)+")){
                    String[] keys = line.split("\\s");
                    line = br.readLine();

                    ArrayList<Integer> results = computeLine(line);

                    for (int i=1; i<keys.length; i++){
                        keys[i] = keys[i].replace("|", "");
                        keys[i] = keys[i].replace(",", "");

                        System.out.println("putting key : " + keys[i] + " value : " + results.get(i-1));

                        ArrayList<Integer> value=  new ArrayList<Integer>();
                        value.add(results.get(i-1));
                        data.put(keys[i],value);
                    }
                }
            }

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // print the data
        for (Entry<String, ArrayList<Integer>> entry : data.entrySet()){
            System.out.println("variable : " + entry.getKey()+" value : "+ entry.getValue() );
        }
}

    // the compute line function
    private ArrayList<Integer> computeLine(String line){
        ArrayList<Integer> integerList = new ArrayList<>();
        String[] splitted = line.split("\\s+");
        for (String s : splitted) {
            System.out.println("Compute Line : "+s);
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    // and the main function to call it all
public static void main(String[] args) {
    new ReadAndParse();
}
}