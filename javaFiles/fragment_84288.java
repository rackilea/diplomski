while(continueLoop){
  //Do your code here
  System.out.println("Do you wish to continue? (Y/N) ");
  resume = input.next().charAt(0);
  if (resume == 'y' || resume == 'Y'){}
  else{
  //Do Code here
   continueLoop=false;
   }
} //End while loop.