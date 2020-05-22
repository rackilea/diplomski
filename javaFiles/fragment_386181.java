for (int i = 0; i < name.length(); i++)
{
    if(!Character.isLetter(name.charAt(i)))
    {
        good = false;
    }

    else
    {
        good = true;
    }
}