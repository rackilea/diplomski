public class CheckToWord {
    public static void main(String[] args) {  //main method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the check amount:"); //prompt user to enter check amount

        double number = scanner.nextDouble();
        String[] parsed = parse(Double.toString(number));
        int main = Integer.parseInt(parsed[0]);
        int change = Integer.parseInt(parsed[1]);

        if (main == 0 && change == 0) {
            System.out.print("Zero");
        } else {
            String mwm = moneyWord(main);
            String mwc = moneyWord(change);
            System.out.println("" + mwm + " and " + mwc + " cents");
        }
    }

    private static String[] parse(String number) {
        String[] split = number.contains(".") ? number.split(Pattern.quote(".")) : new String[]{number, "00"};
        String main = split[0];
        String change = split[1].length() >= 2 ? split[1].substring(0, 2) :
                split[1].length() == 1 ? split[1] + "0" : "00";
        return new String[]{main, change};
    }

    private static String moneyWord(int number) {
        if(number > 1000) {
            throw new IllegalArgumentException("Number value should be less than 1000");
        }

        String words = "";  // variable to hold string representation of number
        String onesArray[] = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String tensArray[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};


        if (number < 0) { // convert the number to a string
            String numberStr = "" + number;
            numberStr = numberStr.substring(1);  // remove minus before the number
            return "minus " + moneyWord((int) Double.parseDouble(numberStr));  // add minus before the number and convert the rest of number
        }

        if ((number / 1000) > 0) { // check if number is divisible by 1 thousand
            words += moneyWord(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) { // check if number is divisible by a hundred
            words += moneyWord(number / 100) + " hundred ";
            number %= 100;
        }

        if (number < 20) { // check if number is within the teens
            words += onesArray[number]; // get the appropriate value from ones array
        } else {
            words += tensArray[number / 10]; // get the appropriate value from tens array
            if ((number % 10) > 0) {
                words += "-" + onesArray[number % 10];
            }
        }
        return words;
    }
}