for (long number = limit-1; number > 1; number--) {
        if (isPrime(number)) {
            if ((limit % number == 0)){
                largestPrimeFactor = number;
                 break; 
            }
        }
    }