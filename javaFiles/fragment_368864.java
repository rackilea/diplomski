String username = null;
 // or String username = "";

     //create username 
 atSign = emailAddress.lastIndexOf("@"); 
  if(atSign >= 0){ 
    username = emailAddress.substring(0, atSign);
 } 
 else{ 
     System.out.print("You've entered an invalid email address!");
     System.out.println("Goodbye!");


   // use return to stop code here if in a method(better choice) or
   // if in the main() uncomment the code below
   // System.exit(0);
 }