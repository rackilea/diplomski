public class readfile {
    private Scanner s;

    public static void main(String[] args) {
        readfile r = new readfile();
        r.openFile();

        //tokens in a map that holds the values from the file
        Map<String,String> tokens = r.readFile();
        r.closeFile();

        //this section just demonstrates how you might use the map
        Scanner scanner = new Scanner(System.in);
        String token = scanner.next();

        //This is a simple user input loop. Enter values of the first 
        //column to get the second column - until you enter 'exit'.
        while (!token.equals("exit")) {
            //If the value from the first column exists in the map
            if (tokens.containsKey(token)) {
                //then print the corresponding value from the second column
                System.out.println(tokens.get(token));
            } 
            token = scanner.next();
        }
        scanner.close(); 
    }   

    public void openFile() {
        try {
            s = new Scanner (new File("filename.txt")); 
        } catch(Exception e) {
            System.out.println("file not found "); 
        }
    }   

    //Note this change - the method now returns a map
    public Map<String,String> readFile() {
    Map<String, String> tokens = new HashMap<String,String>();
    while(s.hasNext()) {
        String a = s.next();
        String b = s.next();
        tokens.put(a,b); //we store the two values in a map to use later
    }
    return tokens; //return the map, to be used.
    }    

    public void closeFile() {
        s.close();
    }   
}