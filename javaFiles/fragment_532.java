protected double stdDeviation, variance, mean; 

    public double getY(double x) { 

        return Math.pow(Math.exp(-(((x - mean) * (x - mean)) / ((2 * variance)))), 1 / (stdDeviation * Math.sqrt(2 * Math.PI))); 

    }