public class WordCount {

    public static int countWords (String word, int min, int max)
    {
        int WordCount = 0;
        int CharacterCount = 0;
        int StringLength = word.length();
        int n = 0;

        while (StringLength > 0)
        {
            if (Character.isLetter(word.charAt(n)))
            {
                CharacterCount = CharacterCount + 1;
            }
            else
            {
                if (CharacterCount >= min && CharacterCount <= max)
                {
                    WordCount = WordCount + 1;   
                }
                CharacterCount = 0;
            }
            n = n + 1;  
            StringLength = StringLength - 1;
        }
        if ( CharacterCount > 0 ) {
            WordCount++;
        }

        return WordCount;   
    }

    public static void main(String[] args) {
        System.out.println( countWords("a b c", 1, 1) );
        System.out.println( countWords("This is a string", 1, 100) );
    }
}