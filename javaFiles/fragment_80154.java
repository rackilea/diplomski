public class MyClass {

    public int findNearestPalindrome(int numberEntered) {
        int lowerPalidrome = getLowerPalindrome(numberEntered);
        int higherPalindrome = getHigherPalindrome(numberEntered);
        if (Math.abs(numberEntered - lowerPalindrome) < Math.abs(numberEntered - higherPalindrome) {
            return lowerPalindrome;
        } else {
            return higherPalindrom;
        }
    }

    public int getLowerPalindrome(int baseNumber) {
        for (int i = baseNumber; i > 0; i--) {
            //do logic to find palindrome and return it
        }
    }

    public int getHigherPalindrome(int baseNumber) {
        for (int i = baseNumber; i < LARGE_NUMBER; i++) {
            //do logic to find palindrome and return it
        }
    }
}