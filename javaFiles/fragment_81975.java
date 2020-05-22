try {
   URL url = new URL("example.com/textfile.txt");
   Scanner s = new Scanner(url.openStream());
   // read from your scanner
}
catch(IOException ex) {
   ex.printStackTrace(); // for now, simply output it.
}