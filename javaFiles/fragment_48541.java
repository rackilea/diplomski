public class Answer {
            public static String answer(int n) {
                StringBuilder primeNumberString = new StringBuilder(0);
                int currentPrimeNumber = 2;

                while (primeNumberString.length() < n+5) {
                    primeNumberString.append(currentPrimeNumber);
                    currentPrimeNumber++;
                    for (int index = 2; index < currentPrimeNumber; index++) {
                        if (currentPrimeNumber % index == 0) {
                            currentPrimeNumber++;
                            index = 2;
                        } else {
                            continue;
                        }
                    }
                }

                return primeNumberString.toString().substring(n, n+5)
        }
    }