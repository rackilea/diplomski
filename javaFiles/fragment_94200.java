for i = 2 to 10 {

    1. set a boolean flag for prime to false;

    2. for j = 2 to (i - 1) {  // Since we just need to check modulus till that number
        1. check the result of `i % j`
        2. If any of the result in this loop is `0`, then `i` is not a prime number. 
           So, set the `prime` flag to false, and break out of loop, 
    }
    3. check the value of `prime` flag. If it is `true`, print number is `prime`. 
       Else print not prime 
}