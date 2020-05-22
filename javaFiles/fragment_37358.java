List<Integer> l = new ArrayList<Integer>(); //List to add a,b
        for (int a = 1; a < 10000; a++) {
            int b = calculateSumOfDivisorsOf(a);
            if (calculateSumOfDivisorsOf(b) == a && b != a && !l.contains(a) && !l.contains(b)) { //Check whether list contain a,b
                // amicable numbers
                // a is always amicable
                answer += a;
                l.add(a); //add a to list
                if (b < 10000) {
                    // b is an amicable number under 10000
                    answer += b;
                    l.add(b); //add b to list
                }
            }
        }
        System.out.println(answer);