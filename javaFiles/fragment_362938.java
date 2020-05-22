boolean printTime = false;

...
   if(line.contains("Answer")) {

       if (printTime!= false) {
          System.out.println( count + " " + blockNum + "   " + printState );
          printTime=false;
       }
        ...
  }else{
        //System.out.println("No Answer Statement: " + line);
        printState += line + " / " ;
        printTime=true; // you have one answer 
  }
  ...