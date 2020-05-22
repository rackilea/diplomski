public int computeFac(int input) {
            if (input < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            for ( a = 1 ; a <= input ; a++ ) {
                result = result*a;
            }
            return result;
        }