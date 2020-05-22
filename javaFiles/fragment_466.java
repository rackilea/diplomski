public String fromArabic(int x)
{
    if(x>29 || x<1)
        throw new IllegalArgumentException();
    int tmp = x;
    StringBuilder o = new StringBuilder();
    while(tmp != 0)
    {
        if(tmp >= 5)
        {
            tmp -= 5;
            o.append("\\");
        }
        else if(tmp >= 1)
        {
            tmp-=1;
            o.append("/");
        }
    }
   return o.reverse().toString();
}