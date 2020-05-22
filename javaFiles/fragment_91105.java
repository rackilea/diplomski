public static String[] getRandomStrings(String [] mainStrings, int i) {
    String [] randomStrings = new String[i];
    Random random = new Random();
    for(int index = 0; index < i ; index++){
        randomStrings[index] = mainStrings[random.nextInt(mainStrings.length)];
    }
    return randomStrings;
}