for (filename : filenames) {
   if (filename.matches(".*ham.*")) {
      System.out.println("ham:" + filename);

      // reset these to null (where are they declared?)
      read = null;   
      br = null;   
      try {
         read = new FileReader("trainfiles/"+filename);          
         br = new BufferedReader(read);

         while ((lines = br.readLine()) != null) {
            System.out.println(lines);
            // st = new StringTokenizer(lines);
            // while (st.hasMoreTokens()) {
            //    System.out.println(st.nextToken());
            // }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (br != null) br.close();
         if (read != null) read.close();
      }
   } 
}