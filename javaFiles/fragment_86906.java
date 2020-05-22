public static void main(String[] args) {

    PrintStream oFile = null;
    try {
        oFile = new PrintStream(new File("output.csv"));
        oFile.println("FirstName");

        // Load the array here with student's data
        loadArray();
        for(int i = 0; i < stud.size(); i++)
        {
             oFile.println(stud.get(i).getStudFirstName());
        }
    } catch (FileNotFoundException ex) {
        System.err.println("File not found");
        System.exit(1);
    }
}