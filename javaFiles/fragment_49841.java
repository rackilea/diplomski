public void loadData(String sourceName) {
      try {
        Scanner read = new Scanner(new File("telnos.txt")).useDelimiter("\\Z");
        int i = 1;
        String name = null;
        String telno = null;
        while (read.hasNextLine()) {
            if (i % 2 != 0)
                name = read.nextLine();
            else {
                telno = read.nextLine();
                add(name, telno);
            }
            i++;
        }
      }catch(FileNotFoundException ex) {
         System.out.println("File not found:"+ex.getMessage);
      }
    }