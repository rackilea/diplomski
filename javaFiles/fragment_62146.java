Scanner keyboard = new Scanner(System.in);

System.out.println("Enter the filename for the first file");
String filename = keyboard.nextLine();
File file = new File(filename);                  // file 1
Scanner inputFile = new Scanner (file);          // infile

System.out.print("Enter the filename "
        + "for the second file");
filename = keyboard.nextLine();
File file1 = new File(filename);                 // file 2
PrintWriter outputFile = new PrintWriter(file1); // outfile

while(inputFile.hasNext())
{
    String fileinfo = inputFile.nextLine();
    String uppercaseinfo1 = fileinfo.toUpperCase();
    outputFile.println(uppercaeinfo1);
}

outputFile.close();