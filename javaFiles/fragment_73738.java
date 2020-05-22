BufferedReader(new FileReader("proxy.txt")); 
 List<String> lines = new ArrayList<String>();

 String line = reader.readLine();

 while( line != null ) {
     lines.add(line);
     line = reader.readLine(); }

  Random rand = new Random(); 
   String randomProxy = lines.get(rand.nextInt(lines.size()));