static public byte[] encrypt(String textToEnrypt, String keyString)
  throws Exception
{
    //at the end
    //write this down:
    byte[] newResponse = new byte[cypheredBytes];
    for(int i=0;i &lt; cypheredBytes;i++)
    {
        newResponse[i] = outputBytes[i];
    }
    return newResponse;
}