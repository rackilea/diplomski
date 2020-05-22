do{     
 try{ 

  System.out.println("Choose your option");

  System.out.println("  1. Create List of used car");
  System.out.println("  2. Print list of used car");
  System.out.println("  3. Search ");
  System.out.println("  4. Exit");

  int choose = read.nextInt();

      if ( choose <= 4){
           throw new Exception();
    }

  }catch (Exception e){
  System.out.println("Please enter input option from 1-4");

..rest of code...
}while(choose <= 4);