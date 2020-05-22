public static void main(String[] args) {
    List<Integer> primeFactorList = new ArrayList<Integer>();
    // accept this from user
    int n = 2;

    for (int i = 210;; i++) {
        // find prime factors for each number
        if (findPrimeFactors(i)) {
            primeFactorList.add(i);
        }
        if (primeFactorList.size() == n) {
            System.out.println(primeFactorList.get(n - 1));
            break;
        }
    }
}