public void printRandomStats() {
    Random random = new Random();
    int next = random.nextInt(101);

    if (next <= 30) {
        // this will happen 30% of the time
        System.out.println("Generating stats from 1-30");
    } else if (next <= 75) {
        // this will happen 45% of the time
        System.out.println("Generating stats from 31-75");
    } else if (next <= 95) {
        // this will happen 20% of the time
        System.out.println("Generating stats from 76-95");
    } else {
        // this will happen 5% of the time
        System.out.println("Generating stats from 96-100");
    }

    return;
}