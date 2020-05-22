BufferedReader infile = null;
try {
  infile = new BufferedReader(new FileReader(file));
  String regel = infile.readLine();
  while (regel != null) {
    // Do something with regel.
    regel = infile.readLine();
  }
} catch (Exception e) {
  e.printStackTrace(); // Log the exception.
} finally {
  if (infile != null) {
    infile.close(); // close the resource.
  }
}