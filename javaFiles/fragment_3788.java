public static void main(String[] args) {
    MathStats mathStats = new MathStats();
    getFileInfo(mathStats); //Same class as main.
    System.out.println();
    System.out.println(mathStats.num1.size());
    //num1 should be populated after calling getFileInfo();

} //End of main


private static void getFileInfo(MathStats mathStats) {
    File listOfTickets = new File(**FILE**);
    try {
      //..