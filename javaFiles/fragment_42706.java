String[] sNums = key.split(","); // Mind that the elements will still contain whitespace!

byte[] bNums = new byte[sNums.length];
for( int i = 0; i < bNums.length; i++ )
{
    if( sNums[i].trim().startsWith("0x") )
    {
       bNums[i] = [insert hex parsing here]
    }
    else
    {
       bNums[i] = [insert decimal parsing here]
    }
}