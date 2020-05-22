System.out.println("Enter the row");
 row1 = input.nextInt();
 System.out.println("Enter the col");
 col1 = input.nextInt();

 while(true){
 System.out.println("Enter the element you want to enter");
 tempelement = input.nextLine();
 if(tempelement.equals("N") || tempelement.equals("Y") || tempelement.equals("P") || tempelement.equals("D") || tempelement.equals("G")){
     map[row1][col1] = tempelement;
     break;
  }
 }