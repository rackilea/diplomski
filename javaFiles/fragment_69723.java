public static void  main(String[] args) {


    int[] inputValues={122,2,22,11,234,333,000,5555,8,9,99,1000};



    System.out.println("Duplicate values are:");
      for (int i = 0; i < inputValues.length; i++) {

          String strNumber = new Integer(inputValues[i]).toString();// get string from array

          if(strNumber.length()>1)  // string length must be greater than 1
          {

              Character firstchar =strNumber.charAt(0);  //get first char of string

              String strchker =strNumber.replaceAll(firstchar.toString(), ""); //repalce it with black



              if(strchker.length()==0)   // for duplicate values length must be 0
              {
                  System.out.println(strNumber);

              }

          }


       }


      /*
       * output will be 
       * Duplicate values are:
        22
        11
        333
        5555
        99
       * 
       * 
       */
}