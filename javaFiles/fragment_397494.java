int hh = k.get(0) * 10 + k.get(1);          
if (hh < 24)
{
    if (hh >= h)
    {
        int mm = k.get(2) * 10 + k.get(3);
        if (mm < 60)
        {
            exists = true;
            if (hh > h || mm > m)
            {
                m = mm;
            }
            h = hh;
        }
    }
}