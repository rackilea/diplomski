try{  // try/catch #1
  //code block #1

}  
catch(SomeException e){  

   //code block #2

   try{  // try/catch #2
      //code block #3
   }  
   catch(OtherException e){  
     //code block #4
   }  
   finally {
     // This code runs no matter what happens with try/catch #2 (so
     // after code block #3 and/or #4, depending on whether there's
     // an exception). It does NOT run after code block #1 if that
     // block doesn't throw, does NOT run after code block #2 if
     // that block DOES throw), and does not run if code block #1
     // throws SomeOtherException (code block #5).
   }
}  
catch(SomeOtherException e){    
  //code block #5
} 
finally {
  // This code runs no matter what happens with EITHER
  // try/catch #1 or try/catch #2, no matter what happens
  // with any of the code blocks above, 1-5
}