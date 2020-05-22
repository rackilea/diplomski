ArrayList<String> found_words=new ArrayList<String>();
public static void main(String arguments[])
{
    String data=""; //data from your file
    String[] words=data.split("\\s"); //split the string into individual words
    for(int i=0;i<words.length;i++)
    {
        String current_word=words[i];
        if(!is_present(current_word))
        {
            found_words.add(current_word);
            int count=1;
            for(int j=i+1;j<words.length;j++)
            {
                if(words[j].equals(words[i]))
                    ++count;
            }
            System.out.println("The word "+current_word+" can be found "+count+" times in the file.");
        }
    }
}
static boolean is_present(String word)
{
    for(int i=0;i<found_words.size();i++)
    {
        if(found_words.get(i).equals(word))
            return true;
    }
    return false;
}