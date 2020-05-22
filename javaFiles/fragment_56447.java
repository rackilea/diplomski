void Scan(String filename, int start, int end) {
      Scanner in = null;
      try {
          in = new Scanner(new File(filename));
      } catch(FileNotFoundException e) {
          e.printStackTrace();
      }
      int line = 1;
      while(line < start) {
          in.nextLine();
          line++;
      }
      while(line <= end) {
          System.out.println(in.nextLine());
          line++;
      }
  }