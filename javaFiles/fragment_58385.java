public static void main(String args[]) throws IOException{

Scanner sc1 = new Scanner(new File("C:\\Users\\amank\\eclipse-workspace\\DataStructures\\src\\sample1-pp.txt")); 

ArrayList<String> list = new ArrayList<String>();
//testing
FileWriter writer = new FileWriter ("C:\\Users\\amank\\eclipse-workspace\\DataStructures\\src\\output.txt");; 

if(!sc1.hasNext())
{
    System.out.println("File is empty");
}

try {
    while (sc1.hasNext())
    {

        list.add(sc1.nextLine().trim().toLowerCase().replaceAll("\\p{P}", ""));


    }
    sc1.close();    

    //for testing
    String newLine = System.getProperty("line.separator");

    for(String str: list)
    {
        writer.write(str+newLine);
    }
    writer.close();