public static void main(String []args) {
    int largest = 0; 
    String largestWord = "";
    String banana = new String("It is my phone");
    System.out.println("Results are;");
    for (String retval: banana.split(" ")) {
        for(int i = 0 ; i < retval.length() ; i++) {
            if(i > largest) {
                largest = i;
                largestWord = retval;
            }
        }
    }
    System.out.println(largestWord);
}