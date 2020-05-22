String line = br.readLine();  // First line was read here.

while (line != null && br.getLineNumber() <= 6 ) {   
    line = br.readLine();  // Your first line was overriden here.
    System.err.println(line);
}