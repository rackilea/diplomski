public static int getRandomPINNumber(){
    Random randomGenerator = new Random();
    int randomNo = randomGenerator.nextInt(10000);
    if(randomNo < 1000)
        return getRandomPINNumber(); //repeat if it is less than 1000
    return randomNo;
}