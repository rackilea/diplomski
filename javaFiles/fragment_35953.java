/*Outputs a serious of 5 numbers, starting at 1.

      The difference between one number to the next one is
      a sequence of numbers, starting at 1 and incremented by 1
      i.e: 1,2,3,4,5
    */

    //represents the difference between one number and the next one.
    //the first difference is 1. 
    int step = 1;

    //represents the numbers to output. Initialized to first number
    int outputNumber = 1;

    //loop over all steps
    for( step=1;  step <= 6 ; step++){

        //do output
        System.out.print(" "+ outputNumber ) ; 
        outputNumber += step; //add step to get the next output number 
    }