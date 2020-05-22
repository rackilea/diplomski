private ArrayList<Data> memFile;
private int column;
....
public void sort(){

  memFile.clear(); //Make sure that calling sort twice doesn't break it
  BufferedReader inFile;
  String readLine;
  try{
    inFile = new BufferedReader(new FileReader(inputFile));
    while((readLine = inFile.readLine()) != null){

      try{
        //Read and split the next line
        String[] tokens = readLine.trim().split(",");
        int registration = Integer.parseInt(tokens[0]); //crn number
        String title = tokens[1]; // course name
        String department = tokens[2]; // course department 
        int year = Integer.parseInt(tokens[3]); // course year

        //Convert to a data instance and add to the arrayList
        memFile.add(new Data(registration, title, department, year));
      }catch(NumberFormatException e){
        System.err.println("Found badly formatted line: " + readLine);
      }
    }
    inFile.close();

    //Sort according to the correct field 
    Collections.sort(memFile, new Comparator<Data>(){
      public int compare(Data d1, Data d2){
        switch(column){
          case 0: return d1.crns - d2.crns;
          case 1: return d1.name.compareTo(d2.name);
          case 2: return d1.department.compareTo(d2.department);
          case 3: return d1.year - d2.year;
          default: return 0;
        }
      }
    });
  }
  catch(IOException e){
    System.out.println(e.getMessage());
  }
}