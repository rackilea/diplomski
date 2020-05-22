Scanner scanner = new Scanner(new File("C:/Dropbox (CMA)/1 Research (5)/TA/new Data/SPX Index.csv"));
  arr = new ArrayList<ArrayList<String>>(); 
  while(scanner.hasNext()){
     String line = scanner.nextLine();
     String[] columns = line.split(",");
     Collections.addAll(arr, columns); 
  }
  scanner.close();