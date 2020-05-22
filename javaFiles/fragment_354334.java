public static int setNibble(int num, int nibble, int which)
    {
        int output;
        if(which ==0)
        {
            output = (num & /*65280*/ 0xFFFFFFF0 ) | nibble;
        }
        else
        {
            int shiftNibble = nibble << (4*which) ;
            int shiftMask = 0x0000000F << (4*which) ;
            output = (num & ~shiftMask) | shiftNibble ;
        }
        return output;
    }