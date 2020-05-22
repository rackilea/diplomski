while((line = stream.readLine()) != null)
{
    String[] words = line.split(" ");
    for(int index = 0; index < words.length; index++)
    {
        if(isNumeric(words[index]))
        {
            //you found a number. do something here;
        }
    }
}