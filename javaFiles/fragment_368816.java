public static void main(String[] args) {
        long sum = 0;
        int count = 0;
        int number = 2;
        while (count < 1000) {
            if (isPrime(number)) {
                sum += number;
                count++;
            }
            number++;
        }
        System.out.println(sum);
    }