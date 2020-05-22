while (value >0)

    {

        int digit = value % 10; // this will assign digit with last digit 
                                // from the parameter number . 
                                //In this case 3200 - last digit is 0. % is modulo operation. 
                                //Since it is a loop in every iteration it will 
                                //fetch each digit from the right

        result += digit;    //This will add each of the digit with the result 
                            //which is 0 before the iterations starts. 
                            //ie 0+0+2+3 = 5(after all the iteration)

        value /= 10;        //Resetting value to 320 in first iteration
                            //32 in second iteration and 
                            // 3 in third iteration 
                            // in 4th iteration this will be 0.
    }