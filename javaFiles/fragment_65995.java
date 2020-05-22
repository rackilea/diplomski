private static ArrayList<String> getCsvFiles(FTPFile[] files){
      ArrayList<String> csvFiles = new ArrayList<>(); 
      for (FTPFile file : files) {
        String details = file.getName();
        //if file is csv
        csvFiles.add(details);
      }
      return csvFiles;
    }