private void findPrimes(int min, int max) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter("/home/hduser/prime.txt"));

    for (int i = min; i <= max; i++) {
        boolean isPrime = true;

        if (i == 1) {
            writer.write("1 is not a prime.");
            writer.flush();
            continue;
        }

        if (i == 2 || i == 3 || i == 5 || i == 7) {
            writer.write(i + " is a prime");
            writer.flush();
            continue;
        }

        for (int j = 2; j <= 9; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            writer.write(i + " is a prime.");
            writer.flush();
        } else {
            writer.write(i + " is not a prime. Its factors are ");
            findFactors(i);
            writer.newLine();
            writer.flush();
        }
    }
    writer.close();
}