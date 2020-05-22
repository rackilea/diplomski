items.stream()
     .map(row -> String.join(",",  row))
     .forEach( row  -> {
         try {
             bw.write(row + "\n");
         } catch (IOException e) {
             e.printStackTrace();
         }
     });