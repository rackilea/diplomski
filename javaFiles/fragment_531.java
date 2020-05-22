double variance(double[] population) {
        long n = 0;
        double mean = 0;
        double s = 0.0;

        for (double x : population) {
                n++;
                double delta = x – mean;
                mean += delta / n;
                s += delta * (x – mean);
        }
        // if you want to calculate std deviation

        return (s / n);
}