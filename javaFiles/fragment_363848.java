int index = 0;

while (scan.hasNextLine()){
    String line = scan.nextLine();
    String[] tokens = line.split("  ");

    // you must create a new list everytime or else they will 
    // reference the same object.  That's why you're getting the output.
    // you are.  Also delete the declareation outside of this loop
    // ArrayList<String> NUM;   ----    NUM = new ArrayLis<String>();

    ArrayList<String> NUM = new ArrayLis<String>();

    DATE.add(tokens[0]);

    for (int i = 1; i < tokens.length; i++){
        NUM.add(tokens[i]);
    }

    MAIN.add(index, NUM);
    index++;

    System.out.println(MAIN);

    NUM.clear();


}