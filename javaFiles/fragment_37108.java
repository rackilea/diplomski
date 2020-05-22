public static void readAllBus(ArrayList<Bus> busInformation){
  File infile = null;
  Scanner scan = null;
  int[] fare = new int [3];
  int[] numOfPassenger = new int [3];

  try{
     infile = new File("busData.csv");
     scan = new Scanner(infile);
  }//end try
  catch(FileNotFoundException e){
     System.out.println("Error! File not found!");
     System.exit(0);
  }//end catch

  while(scan.hasNext()){
     String [] str = scan.nextLine().split(",");

     if(str[0].equals("cr")){

     if(str.length>7){
          for(int i = 0; i < 3; i++){
          fare[i] = Integer.parseInt(str[i+4]);
          }
      }

      if(str.length>10){
        for(int i = 0; i < 3; i++){
          numOfPassenger[i] = Integer.parseInt(str[i+7]);
          }
       }

      busInformation.add(new BusTrip(str[1],
                           Integer.parseInt(str[2]),
                           Integer.parseInt(str[3]),
                           fare,
                           numOfPassenger,
                           str[10]));

    }//end if
  }//end while    
 }//end readAllBus