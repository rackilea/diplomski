for (i = firstNum; i <= secondNum; i++) {
        int divisors = 0;
        for (j = 1; j <= i; j++) {
            if (i % j == 0) {
                divisors++;
            }
        }
        if (divisors == 2) {
            System.out.println(++count + ". " + i);
          }
      }
   }
}