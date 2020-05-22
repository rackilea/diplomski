public class TestReturn {

    public static void main(String[] args) {
        int beer = 69;
        System.out.println( beer + " : " + rounds(beer) + ones(beer));

    }

    public static String rounds(int beer) // beer must be declared either as a parameter or as a local variable
    {
        if (beer > 89)
            return "Ninety";
        else if (beer > 79)
            return "Eighty";
        else if (beer > 69)
            return "Seventy";
        else if (beer > 59)
            return ("Sixty");
        else if (beer > 49)
            return ("Fifty");
        else if (beer > 39)
            return ("Forty");
        else if (beer > 29)
            return ("Thirty");
        else if (beer > 19)
            return ("Twenty");
        else if (beer == 19)
            return "Nineteen";
        else if (beer == 18)
            return "Eighteen";
        else if (beer == 17)
            return ("Seventeen");
        else if (beer == 16)
            return ("Sixteen");
        else if (beer == 15)
            return ("Fifteen");
        else if (beer == 14)
            return ("Fourteen");
        else if (beer == 13)
            return ("Thirteen");
        else if (beer == 12)
            return ("Twelve");
        else if (beer == 11)
            return ("Eleven");
        else if (beer == 10)
            return ("Ten");
        else                        // you have to cover all conditions
            return "none";          // thus you should add these
    }

    private static String ones(int beer) // beer must be declared either as a parameter or as a local variable
    {
        if (beer % 10 == 9)
            return ("-Nine");
        else if (beer % 10 == 8)
            return ("-Eight");
        else if (beer % 10 == 7)
            return ("-Seven");
        else if (beer % 10 == 6)
            return ("-Six");
        else if (beer % 10 == 5)
            return ("-Five");
        else if (beer % 10 == 4)
            return ("-Four");
        else if (beer % 10 == 3)
            return ("-Three");
        else if (beer % 10 == 2)
            return ("-Two");
        else if (beer % 10 == 1)
            return ("-One");
        else if (beer % 10 == 0)
            return ("Zero");
        else                        // you have to cover all conditions
            return "none";          // thus you should add these
    }
}