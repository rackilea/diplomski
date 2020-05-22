int counter = 0;

 while (rs.next()) {
        String DocumentName = rs.getString(2); 
        doc1 = DocumentName;
        try {

            File file = new File("///" + counter + ".txt");  // path to output folder.
            FileWriter fileWritter = new FileWriter(file,true);
            BufferedWriter out = new BufferedWriter(fileWritter);
            out.write(doc1);
            out.newLine();
            out.close();
            counter++;

              } catch (IOException e1) {
          System.out.println("Could not write in the file");
        } 
      }