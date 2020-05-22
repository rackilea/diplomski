public static short[][] brighten(short[][] orig, short amount) {
    Random random = new Random();
    short[][] returnArray = new short[orig.length][orig[0].length];
    for(int i = 0; i < orig.length; ++i){
        for(int j = 0; j < orig[0].length; ++j){
            int randomValue = -amount + random.nextInt(amount+amount);
            returnArray[i][j] = (short)(orig[i][j]+randomValue);
        }
    }
    return returnArray;
}