public class DigitFolder {
    public static void main(String[] args) {
        int hashVal = hashFunc(424124967);
        System.out.println(hashVal);
    }
    public static int hashFunc(int key) {
        int arraySize = 1021;
        int keyDigitCount = getDigitCount(key);
        int groupSize = getDigitCount(arraySize);
        int groupSum = 0;
        String keyString = Integer.toString(key);
        int i;
        for (i = 0; i < keyString.length(); i += groupSize) {
            if (i + groupSize <= keyString.length()) {
                String group = keyString.substring(i, i + groupSize);
                groupSum += Integer.parseInt(group);
            }
        }
        // There is no remaining part if count is divisible by groupsize.
        if (keyDigitCount % groupSize != 0) {
            String remainingPart = 
                   keyString.substring(i - groupSize, keyString.length());
            groupSum += Integer.parseInt(remainingPart);
        }
        return groupSum % arraySize;
    }
    public static int getDigitCount(int n) {
        int numDigits = 1;
        while (n > 9) {
            n /= 10;
            numDigits++;
        }
        return numDigits;
    }
}