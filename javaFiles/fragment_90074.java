Set<Integer> set = new TreeSet<>();
            for(int i = 0; i < a.length; i++) {
                boolean isPrime = true;
                if(isPrime(a[i]) && isPrime(r[i]))
                    set.add(a[i]);
            }
Iterator it = set.iterator();
        while(it.hasNext())
            System.out.print(it.next() + " ");