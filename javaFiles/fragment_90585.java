public class FirstWord {

    public static void main(String[] args) throws Exception
    {
        String words = "One two many lots"; // This will be our input
        System.out.println(firstWord(words)); 
    }

    // Method that returns the first word
    public static String firstWord(String input) {

        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ')
            {
                return input.substring(0, i);
            }
        }

        return input; 
    }    
}