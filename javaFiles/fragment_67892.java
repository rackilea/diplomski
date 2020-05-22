// in constants declaration
public final static int ROWS = 2;
public final static int COLS = 10;

// somewhere else in your code.
char[][] chars = new char[ROWS][COLS];

// making sure to catch exceptions with opening and reading file
BufferedReader br = new BufferedReader(new FileReader("files/myFile.txt"));

for(int i = 0; i < ROWS; ++i) {
  String line = br.readLine();

  // check line exists, has a length of COLS, else throw exception.

  chars[i] = line.toCharArray();
}