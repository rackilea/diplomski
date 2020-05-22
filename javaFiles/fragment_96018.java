public static void main(String[] args) {
    boolean sevNine = false; // a combination of seven and nine in a number
    boolean oneNine;
    boolean oneSeven;
    int counter = 0;
    for (int i = 0; i < 1000000; i++) // Runs numbers 1-1000000
    {
        oneSeven = false;
        oneNine = false;
        String number2 = " " + (i); // sets a nmber to a string
        int length = number2.length() - 1; // length goes up to the last character 0-j
        for (int j = 0; j <= length; j++) // looking for the first 7 or 9 in string
        {
            char a = number2.charAt(j); // sets char to the next "letter"
            if (a == '7' && oneSeven != true) // if the number is a 7 and there isnt already a seven
            {
                oneSeven = true; // now there is a seven,
                for (int k = j + 1; k <= length; k++) // checks from the next char up to the length for a 9
                {
                    char b = number2.charAt(k);
                    if (b == '9') {
                        sevNine = true;
                    }
                }
            } else if (a == '9' && oneNine != true) {
                oneNine = true;
                for (int l = j + 1; l <= length; l++) {
                    char b = number2.charAt(l);
                    if (b == '7') {
                        sevNine = true;
                    }
                }
            }
            if (sevNine == true) {
                counter++;
                sevNine = false;
                System.out.println(number2);
                break;
            }
        }
    }
    System.out.println(counter);
}