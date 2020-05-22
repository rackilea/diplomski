public class BigNumberTest2 {

    public static void main(String[] args) {
        /*Array with the digits of the number. 0th index stores the most significant digit*/
        //int[] num = new int[1000000];

        //Can have a million digits, length is 1 + needed to avoid overflow
        int[] num = {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        int base = 10;
        int step = 1;
        String endNum = "100000000000000000000000000000000000000000000000000020";//Can have a million digits

        while(true) {
            //Increment by step
            for(int carry = step, i = num.length - 1; carry != 0 && i >= 0; i--) {
                int newDigit = num[i] + carry;

                num[i] = newDigit % base;
                carry = newDigit / base;
            }

            //Find the position of most significant digit
            int mostSignificantDigitIndex = 0;
            while(num[mostSignificantDigitIndex] ==  0) {/*No need to check if firstNonZero < num.length, as start num >=0 */
                mostSignificantDigitIndex++;
            }

            StringBuilder strNum = new StringBuilder();
            //Concatenate to get actual string
            for(int i = mostSignificantDigitIndex; i < num.length; i++) {
                strNum.append(num[i]);
            }

            System.out.println(strNum);

            //Check if number current number is greater or equal to endNum
            if(strNum.length() > endNum.length() || (strNum.length() == endNum.length() && strNum.toString().compareTo(endNum) >= 0)) {
                break;
            }
        }
    }
}