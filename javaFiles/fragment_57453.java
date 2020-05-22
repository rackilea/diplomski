private static Random rand = new SecureRandom();
public int randInt(int min, int max) {
    // Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
 }