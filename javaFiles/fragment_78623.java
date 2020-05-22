public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int num = 54; //THis can be whatever you want
        while(!isPalindrome(Integer.toString(num))){
            int n = reverseInt(num);
            num +=n;
        }
        System.out.println(num);
    }
    //Checks if a number is a string is a palindrome
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    //Takes an int, reverses it
    public static int reverseInt(int input)
    {
        long reversedNum = 0;

        long input_long = input;

        while (input_long != 0)
        {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
        {
            throw new IllegalArgumentException();
        }
        return (int)reversedNum;
    }
}