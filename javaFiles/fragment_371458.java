for(int x = 0;x<fileString.length();x++)
{
    Character c = keyMapper.get(fileString.charAt(x));
    if (c != null)
        fileString.setCharAt(x, c);
}