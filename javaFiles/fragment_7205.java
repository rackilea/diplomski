for(i=2; i < 100; i++) {
            isprime = true;
            for (j=2; j <= i/j; j++)
                if((i%j) == О) isprime = false;
            if (isprime)
                System.out.println(i +" - is a prime number."); 
        }