boolean prime = true;
    for (int p = 2; p < sum; p++) {
        if (sum % p == 0) {
            prime = false;
            break;
        }
    }
    if (prime)
        System.out.println("The sum is a prime number.");
    else
        System.out.println("The sum is not a prime number.");