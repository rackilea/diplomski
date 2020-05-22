JTextField[] textFields = new JTextField[10];
// ... init your textFields here

int line =0;  // first line will be first textfield and so on
Scanner scanner = new Scanner(new File("reload.txt"));  // use Scanner instead of FileReader, it's easier :) 
while(scanner.hasNextLine()){   // as long as you did not reach the end of the file
    textFields[line++].setText(scanner.nextLine()); // get the next line and put it in the respective textfield
}