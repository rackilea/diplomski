Random randomGenerator = new Random();

for (int i = 0; i < 100; i++) {
    int randomInt = randomGenerator.nextInt(99999);
    H.insert(""+randomInt);
}