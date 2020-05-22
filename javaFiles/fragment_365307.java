public static void main(String[] args) throws FileNotFoundException {

    PrintWriter pw = new PrintWriter(new FileOutputStream("file.txt"));

    for (int row = 0; row < 4; row++) {
        for (int col = 0; col < 4; col++) {
            pw.print(row + "" + col + "\t");
        }
        pw.println("\n");
    }
    pw.close();   // it calls flush() method to push the data in the file
}