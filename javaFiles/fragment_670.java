try {
       //Add your code here

  } catch(ArrayIndexOutOfBoundsException arrayIndexExe) {
    //Change the below message according your requirement
    String message ="Input Validation failed because of incorrect data"; 

    //You can set the cause (2nd arg) below as ArrayIndexOutOfBoundsException
    throw new IllegalArgumentException(message, arrayIndexExe);
  }