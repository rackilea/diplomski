String[] lineArray = new String[4]; // this is not needed, it gets overwritten
...
try {
  br = new BufferedReader(new FileReader(listInput));
  String line = br.readLine();
  while(line != null){
    line = br.readLine();
    line = line.toUpperCase(); // this will NPE
    ...
    lineArray = null; // you don't need this
  }
}