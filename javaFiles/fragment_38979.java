double double1=-1;
while (double1!=-1){
     String number=input.next();
     try{
         double1=Double.parseDouble(number);
     }catch(NumberFormatException e){
       //that wasn't proper input.
         System.out.println ("Error: Enter a number");

     }
}