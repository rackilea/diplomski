public double sinLoops(double x) {
        int i = 0; //this didn't exist.
        double result = 0;
        double seriesElement; //You need the individual taylor series element.
        do {
            double potenz2 = x; //these need to be reset each time.
            double fac = 1; //if not they overflow and infinity/infinity is NaN and it exits.
            int potenz1 = ((i & 1) == 1) ? -1 : 1; //this is just short hand.
            for (int counter = 1; counter < (2 * i + 1); counter++) {
                potenz2 *= x;
            }
            for (int counter2 = (2 * i + 1); counter2 >= 1; counter2--) {
                fac *= counter2; //we could actually keep the last iteration and do 2*(i-1)+1 to 2*i+1 each new i.
            }
            seriesElement = potenz1 * potenz2 / fac; //we need to save the value here.

            result += seriesElement; //we are summing them in the results.
            i++;

        } while (seriesElement > 0.0000001 || seriesElement < -0.0000001); //We check this conditional against the series element, *NOT THE RESULT*
        return result;
    }