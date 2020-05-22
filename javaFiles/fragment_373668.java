public File openFile(String URI); // write this yourself

public void readFile(File names) {
  BufferedReader br = new BufferedReader(new FileReader(name));

  while(br.ready()) {
    String next = br.readLine();
    String[] split = next.split(" : ");
    // handle each case, etc.