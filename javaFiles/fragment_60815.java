int powMod(int z, int s, int t){
        long result = 1; //int * int will never exceed the size of a long
        long multiplicant = z;
        while(s > 0){
            if(s % 2 == 1) {
                result *= multiplicant;
                result %= t; // do modulo on each temporary result to keep accuracy
            }

            multiplicant *= multiplicant;
            multiplicant %= t;
            s /= 2;

        }
        return result;
    }