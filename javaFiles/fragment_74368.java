LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("names.txt"))); // Your file name
lnr.skip(Long.MAX_VALUE);
int size = lnr.getLineNumber() + 1; // +1 because line numbering begins at 0
lnr.close();

// Use the size for your array declarationg
String[] nameArray = new String[size];