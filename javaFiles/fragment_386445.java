class Ideone
{
    private static void checkPalindrome(String i) {
        int left = 0;
        int right = i.length() -1;
        System.out.println("This word is: " + i);
        System.out.println("Checking charAt(" + left + ") which is " +
            i.charAt(left) + " and chartAt(" + right + ") which is " +
            i.charAt(right));
        while(i.charAt(left) == i.charAt(right) && right > left) {
            left++; right--;
            System.out.println("Checking charAt(" + left + ") which is " +
                i.charAt(left) + " and chartAt(" + right + ") which is " +
                i.charAt(right));
        }

        System.out.println();
        if (left < right)
            System.out.println ("That string is Not a palindrome.");
        else
            System.out.println("That string IS a palindrome");
        System.out.println();
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        checkPalindrome("racecar");
        checkPalindrome("abba");
        checkPalindrome("java");
    }
}