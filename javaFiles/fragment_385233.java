Scanner in = new Scanner(System.in);
String input = "";
String lastResult = "";

while(!(input = in.nextLine()).equals("."))
{
    String[] userInput = input.split("\\s+");

    if(userInput.length == 3)
    {
        String firstRoman = userInput[0];
        String operator = userInput[1];
        String secondRoman = userInput[2];

        if(firstRoman.matches("[MCDXLVImcdxlvi]+") && operator.matches("\\+|\\-|\\*|\\/") && secondRoman.matches("[MCDXLVImcdxlvi]+"))
        {
            int romanConvertedNumber = (compute(romanToNumber(firstRoman), operator, romanToNumber(secondRoman)));
            lastResult = IntegerToRomanNumeral(romanConvertedNumber); //method to convert number to roman
            System.out.println(lastResult);
        }
        else{
            System.out.println("Error: Wrong input");
        }

    }
    /* check if */
    else if( ( userInput.length == 2 ) & ( ! lastResult.equals("") ) ){ 
        String firstRoman = lastResult;
        String operator = userInput[0];
        String secondRoman = userInput[1];

        if(firstRoman.matches("[MCDXLVImcdxlvi]+") && operator.matches("\\+|\\-|\\*|\\/") && secondRoman.matches("[MCDXLVImcdxlvi]+"))
        {
            int romanConvertedNumber = (compute(romanToNumber(firstRoman), operator, romanToNumber(secondRoman)));
            lastResult = IntegerToRomanNumeral(romanConvertedNumber); //method to convert number to roman
            System.out.println(lastResult);
        }
        else{
            System.out.println("Error: Wrong input");
        }
    }
    else{
        System.out.println("Error: Wrong input");
    }
}