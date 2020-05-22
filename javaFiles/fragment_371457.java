for(int x = 0;x<fileString.length();x++)
{
    for(Map.Entry<Character, Character> entry : keyMapper.entrySet())
    {
        if(fileString.charAt(x)==entry.getKey())
        {
            fileString.setCharAt(x,entry.getValue());
        }

    }
}