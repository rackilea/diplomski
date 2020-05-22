public char getCharacter(final String code)
{
    for (char character : code.toCharArray())
    {
        if (   (character >= 'a' && character <= 'z')
            || (character >= 'A' && character <= 'Z'))
        {
            return character;
        }
    }
    throw new RuntimeException("No character in ID: " + code);
}