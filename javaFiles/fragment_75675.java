try{
     int number = Integer.parseInt(numberInput);
     if(number>0 && number<101){
       txtLinearOutput.setText(listOfBooks[number-1]);
     }else{
        // out of range
     }
 }catch(Exception e){
   // handle exception here
 }