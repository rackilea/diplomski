public static void main(String[] args) throws Exception {
    UserInterfaceOrNot ui = new UserInterfaceOrNot();
    String inputFile1 = args[0];
    String inputFile2 = args[1];

    String input1AsString = ui.readFileAsString(inputFile1);
    String input2AsString = ui.readFileAsString(inputFile2);
    //continue with your logic
}