for (int a = 1; a < 10000; a++) {
        int b = calculateSumOfDivisorsOf(a);
        if (calculateSumOfDivisorsOf(b) == a && b != a) {
            // amicable numbers
            // a is always amicable
            answer += a;
            System.out.println(a); //NOTE I AM PRINTING 'a'
            if (b < 10000) {
                // b is an amicable number under 10000
                answer += b;
                System.out.println(b); // //NOTE I AM PRINTING 'b'
            }
        }
  }