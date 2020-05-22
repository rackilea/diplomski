public double sinLoops(double x) {
        double result = 0, powerx = -1, fac = 1;
        int i = 0, n, m = 0;
        while (true) {
            n = m;
            m = (i++*2) + 1;
            powerx *= -1;
            while (n < m) {
                powerx *= x;
                fac *= ++n;
            }
            if ((Double.isInfinite(fac)) || (Double.isInfinite(powerx))) break;
            result += powerx / fac;
        }
        return result;
    }