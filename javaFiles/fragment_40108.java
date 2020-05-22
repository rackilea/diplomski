public static void main(String[] args) throws IOException {

    FileReader fileReader = new FileReader("test.txt");
      BufferedReader br = new BufferedReader(fileReader);

      int startPosition = 0;
      String line;
      ArrayList<String> items = new ArrayList<String>();
      while((line = br.readLine() ) != null)
      {
          items.add(line.substring(startPosition, line.length()));
          System.out.println(line.substring(startPosition, line.length()));
          startPosition = line.length();

      }

      write("test2.txt", items);
}

public static void write (String filename, ArrayList<String> items) throws IOException{

    BufferedWriter outputWriter = null;
    outputWriter = new BufferedWriter(new FileWriter(filename));

    for (String item : items) {

        outputWriter.write(item);
        outputWriter.newLine();
    }
    outputWriter.flush();  
    outputWriter.close();  
}