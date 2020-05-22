File tempFile = new File("<SubdirectoryIfAny/name_of_file.txt");

Scanner readFile = new Scanner( tempFile );

// Assuming that you can structure the file as you please with fx each bit of info
// on a new line.

int counter = 0;
while ( readFile.hasNextLine() ) {
    score[counter] = readFile.nextLine();
    counter++;
}