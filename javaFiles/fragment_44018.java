import java.util.*; // for the scanner
import java.io.*; // for the object

File f = new File("<filename>");
Scanner input = new Scanner(f);

input.useDelimiter(",|\"|\n"); // delimiters are commas, quotes, and newlines

input.nextInt(); //reads 1111 as an integer
input.next(); // reads the empty space (needed because " " wasn't declared as a delimiter)
input.next(); // reads in Top Secret Twenty One - Janet Evanovich as a String.
input.next(): // reads in the empty space
input.nextDouble(); // reads in 8.99 as a double