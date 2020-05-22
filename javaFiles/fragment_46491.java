public static void main(String[] args) {
    // Setup
    char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
    int prime = 11; // MUST be greater than the length of the set
    int skip = 0;
    int nextMember = 0;

    // If the skip value is divisible by the prime number, we will only access
    // index 0, and this is not what we want.
    while (skip % prime == 0) {
        // Generate three random positive, non-zero numbers
        int ra = new Random().nextInt(prime) + 1;
        int rb = new Random().nextInt(prime) + 1;
        int rc = new Random().nextInt(prime) + 1;
        skip = ra * chars.length * chars.length + rb * chars.length + rc;
    }

    String result = "";
    for (int x = 0; x < chars.length; x++) {
        do {
            nextMember += skip;
            nextMember %= prime;
        } while (nextMember <= 0 && nextMember > chars.length);
        result += chars[nextMember - 1];
    }

    // Print result
    System.out.println(result);
}