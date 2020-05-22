int n =  primeNumber.size();
for (int k = 0; k <n-1; k++) {
        for (int j = 0; j <n-k-1; j++) {
            int a = primeNumber.get(j) % primeNumber.get(j+1);
            if (a != 0) {
                finalPrime.add(k);
                break;
            }
        }
    }