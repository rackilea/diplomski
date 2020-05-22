public static void main(String[] args) {
    try {
      File inputfile1 = new File("C:/_mystuff/test.txt");
      File inputfile2 = new File("C:/_mystuff/test2.txt");

      Scanner readerL = new Scanner(inputfile1);
      Scanner readerR = new Scanner(inputfile2);

      String line1 = readerL.nextLine();
      String line2 = readerR.nextLine();
      while (line1 != null || line2 != null) {
        if (line1 == null) {
          System.out.println("from file2 >> " + line2);
          line2 = readLine(readerR);
        } else if (line2 == null) {
          System.out.println("from file1 >> " + line1);
          line1 = readLine(readerL);
        } else if (line1.compareToIgnoreCase(line2) <= 0) {
          System.out.println("from file1 >> " + line1);
          line1 = readLine(readerL);
        } else {
          System.out.println("from file2 >> " + line2);
          line2 = readLine(readerR);
        }
      }
      readerL.close();
      readerR.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static String readLine(Scanner reader) {
    if (reader.hasNextLine())
      return reader.nextLine();
    else
      return null;
  }