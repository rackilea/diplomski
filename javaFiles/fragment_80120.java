public class NewClass {
   public static void main(String[] args) {
      List<String> list = new ArrayList<String>();
      list = readFile("uzochi");
      writeToFile(list);
   }

public static  List<String> readFile(String name){
    List<String> list = new ArrayList<String>();
    try {
        FileReader reader = new FileReader("C:\\users\\uzochi\\desktop\\txt.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        boolean nameFound = false;

        while ((line = bufferedReader.readLine()) != null) {
            if(line.equalsIgnoreCase(name)){
                nameFound = true;
                System.out.println("searched name: "+line);
            }
                if(nameFound){                        
                    list.add(line);

                    line = bufferedReader.readLine();
                    System.out.println("line to replace: " + line);
                    line = "another string";
                    System.out.println("replaced line: "+line);
                    list.add(line);
                    nameFound = false;
                }
                else{
                    list.add(line);
                }
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    return list;
}

public static void writeToFile(List<String> list){
    try {
            FileWriter writer = new FileWriter("C:\\users\\uzochi\\desktop\\txt.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(String s: list){
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            } 

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }