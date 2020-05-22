public static void main(String[] args) throws IOException{
    //declare reader and writer
    BufferedReader reader = null;
    PrintWriter writer = null;

    //hash map to store the data of the first file
    Map<String, String> names = new HashMap<String, String>();

    //read the first file and store the data
    reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("IRStudents.txt"))));
    String line;
    String[] arg;
    while((line = reader.readLine()) != null){
        if(!line.startsWith("-")){
            arg = line.split(" ");
            names.put(arg[0], arg[1]);
        }
    }
    reader.close();

    //read the second file, merge the data and output the data to the out file
    writer = new PrintWriter(new FileOutputStream(new File("File_2.txt")));
    reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Marks.txt"))));
    while((line = reader.readLine()) != null){
        arg = line.split(" ");
        writer.println(arg[0] + " " + names.get(arg[0]));
        writer.println("Marks: " + arg[1]);
        writer.println("- - - - - -");
    }
    writer.flush();
    writer.close();
    reader.close();
}