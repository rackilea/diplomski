public static ArrayList<Integer> allDivisors(int number) {
    ArrayList<Integer> divisors = new ArrayList<>();

    for (int i = 1; i <= number; i++) {
        if(number % i == 0) {
            divisors.add(i);
        }
    }
    return divisors;
}