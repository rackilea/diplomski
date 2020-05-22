StringBuffer strBuff = new StringBuffer();
for(int i = 0; i<str.length(); i++)
{
    if(str.charAt(i) == reqChar)
    {
        strBuff.append(str.charAt(i));
    }
    else
    {
        strBuff.append('0');
    }
}
return str.toString();