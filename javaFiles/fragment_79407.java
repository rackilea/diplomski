public double[] divideUniformlyRandomly(double number, int part) {
    double uniformRandoms[] = new double[part];
    Random random = new Random();

    double mean = number / part;
    double sum = 0.0;

    for (int i=0; i<part / 2; i++) {
        uniformRandoms[i] = random.nextDouble() * mean;

        uniformRandoms[part - i - 1] = mean + random.nextDouble() * mean;

        sum += uniformRandoms[i] + uniformRandoms[part - i -1];
    }
    uniformRandoms[(int)Math.ceil(part/2)] = uniformRandoms[(int)Math.ceil(part/2)] + number - sum;

    return uniformRandoms;
}