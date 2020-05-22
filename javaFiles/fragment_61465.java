private static long toLong(byte[] value) 
{
    long res = 0;
    int tempInt = 0;
    String tempStr = ""; //holds temp string Hex values

    tempStr = bytesToHex(value);

    if (value[0] < 0 ) 
    { 
        tempInt = value.length;
        for (int i=tempInt; i<8; i++) { tempStr = ("FF" + tempStr); }

        res = Long.parseUnsignedLong(tempStr, 16); 
    }
    else { res = Long.parseLong(tempStr, 16); }

    return res;

}