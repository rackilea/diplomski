public PrintWriter(File file) throws FileNotFoundException {
     this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))),
     false);
}


public FileWriter(File file) throws IOException {
       super(new FileOutputStream(file));
}