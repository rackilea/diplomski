for (int counter = 0 ; counter < pt.length; counter++)
    {
        i = ((i + 1) % 256) & 0xFF;
        j = ((j + s[i]) % 256) & 0xFF;

        //classic swap
        temp    = s[j];
        s[j]    = s[i];
        s[i]    = temp;

        t = ((s[i] + s[j]) % 256) & 0xFF;

        k = s[t];

        ct[counter] = (byte) (k ^ pt[counter]);