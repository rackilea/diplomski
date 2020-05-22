try(BufferedReader br = new BufferedReader(new FileReader(listInput))) {
  String line = null;
  while((line=br.readLine()) != null){
    String[] lineArray = line.toUpperCase().split("\\s+");
    tm1.put(lineArray[0], lineArray[1]);//Place array items into treemaps.
    tm2.put(lineArray[0], lineArray[2]);
    tm3.put(lineArray[0], lineArray[3]);
    System.out.print(tm1 + "\n" + tm2 + "\n" + tm3 + "\n");//Test if data is received 
  }
}