public String byteRangeToString(byte[] data)
{
    try
    {
         return new String(data, "UTF-8");
    }
    catch (UnsupportedEncodingException e)
    {
         /* handle accordingly */
    }
}