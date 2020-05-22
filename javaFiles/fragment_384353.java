public class validNumbers {

    public static void main(String[] args) {

        System.out.println(parseInt("345"));
        System.out.println(parseInt("-345"));
        System.out.println(parseInt("a-345"));
        System.out.println(parseInt("1a5b"));
    }

    public static int parseInt(String str) {
        String numberWithoutSign = removeSign(str);
        if (isValidNumber(numberWithoutSign)) {
            int sum = 0;
            int position = 1;
            for (int i = numberWithoutSign.length() - 1; i >= 0; i--) {
                int number = numberWithoutSign.charAt(i) - '0';
                sum += number * position;
                position = position * 10;
            }
            if(isNegative(str)){
                return -(sum);
            }else{
                return sum;
            }
        }
        return -1;
    }

    /**
     * Removes sign in number if exists
     */
    public static String removeSign(String number){
        if(number.charAt(0) == '+' || number.charAt(0) == '-'){
            return number.substring(1);
        }else{
            return number;
        }
    }
    /**
     * Determines if a number is valid
     */
    public static boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c >= '0' && c <= '9'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a number is negative or not
     */
    public static boolean isNegative(String number){
        if(number.charAt(0) == '-'){
            return true;
        }else{
            return false;
        }
    }

}