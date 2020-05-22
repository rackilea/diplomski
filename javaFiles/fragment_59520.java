public static String[] tokenize(String sentence) 
{
    int wordCount = countWords(sentence);
    String[] wordArr = new String[wordCount];
    int wordCounter = 0;

    for(int i = 0; i < sentence.length(); i++)
    {
        if(sentence.charAt(i) == ' ' || i == sentence.length() - 1)
        {
            wordCounter++;

        }
        else
        {
            if(wordArr[wordCounter] == null)
            {
                wordArr[wordCounter] = "";
            }
            wordArr[wordCounter] += sentence.charAt(i);
        }

    }

    return wordArr;

}