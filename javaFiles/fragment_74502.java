public static void main(String [] args) {
    //First input dialog. Example from user will be like:  image1.gif
    String directions = JOptionPane.showInputDialog("Please input name of first image file");

    // System.in will set up the scanner to read user input from the keyboard. 
    // myScanner.next() will grab the first "token" (a section of text without spaces) from this input
    Scanner myScanner = new Scanner(System.in);

    // Create variables to store name, number and extension
    String letters, number, ext;
    String fileName = myScanner.next();
    if (fileName.indexOf(".") > -1) {
        String[] a = userInput.split(".");
        letter = a[0].replaceAll("[0-9.]", "");
        number = a[0].replaceAll("[^0-9.]", "");
        ext = a[1];
    }
}