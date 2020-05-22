public static void write (String filename, int[]x) throws IOException{
  BufferedWriter outputWriter = null;
  outputWriter = new BufferedWriter(new FileWriter(filename));
  for (int i = 0; i < x.length; i++) {
    // Maybe:
    outputWriter.write(x[i]+"");
    // Or:
    outputWriter.write(Integer.toString(x[i]);
    outputWriter.newLine();
  }
  outputWriter.flush();  
  outputWriter.close();  
}