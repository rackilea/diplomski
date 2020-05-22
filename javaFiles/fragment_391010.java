for (int number = 2; count <= limit; number++) {
        // print prime numbers only
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false; // number is divisible so its not prime
                break;
            }
        }
        if (isPrime) {
            System.out.println(number);
            count++;
        }
    }