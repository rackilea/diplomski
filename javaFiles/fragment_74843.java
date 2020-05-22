public static boolean Search(ArrayList<String> ArrayToSearch,String word)
{
    String temp;
    for(int counter = 0;counter < ArrayToSearch.size();counter++)
    {
        temp = ArrayToSearch.get(counter);
        if(temp.equals(word.toLowerCase()))
        {
            position = counter;
            return true;
        }
    }
    return false;
}