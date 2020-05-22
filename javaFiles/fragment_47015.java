boolean done = false;
do {

 try{
  System.out.println("Enter your percentage");
  int percent = (int) console.readDouble();

  // more code
  // if the condition is satisfied then assign done = true;

 } catch(InputMismatchException e) {
    System.out.println("Please input only numbers");
 }
} while(!done);