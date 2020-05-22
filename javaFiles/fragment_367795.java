double[] v = {1.0, 2.0, 3.0, 4.0, 5.0};
    StandardDeviation sd = new StandardDeviation(false);
    sd.evaluate(v);
    // returns 1.414

    StandardDeviation sd2 = new StandardDeviation();
    sd2.evaluate(v);
    // returns 1.581