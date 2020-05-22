try{
    File file = new File("C:\\Users\\Lizi\\Documents\\Uni Work\\Year 2\\PHYS281\\Project\\test.txt");
    Scanner scnr = new Scanner(file);
    int i = 0;

    while(i<9 && scnr.hasNextLine()){
      //read values from file and set as Planet object, then set to array.
      i++
    }
  }catch(FileNotFoundException e){
    System.out.println("File not found!");
  }