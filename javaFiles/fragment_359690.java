public int comparePostalCode(CP p1, CP p2)
{
    int reg1,sec1,reg2,sec2; /* region codes and sector codes */

    /* extract region code from arguments */
    reg1 = p1.getRegionCode();
    reg2 = p2.getRegionCode();
    if (reg1<reg2)
        return -1; /* p1 is smaller than p2 by region code*/
    else if (reg1>reg2)
        return 1; /* p1 is larger than p2 by region code*/
    else
    {
        sec1=p1.getSectorCode();
        sec2=p2.getSectorCode();
        if (sec1<sec2)
            return -1; /* p1 is smaller than p2 by sector code*/
        else if (sec1>sec2)
            return 1; /* p1 is larger than p2 by sector code*/
        else
            return 0;
    }
}