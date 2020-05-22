public static String complimentDecimal(String strnew)
{
    int s2=Integer.parseInt(strnew,2);
    if (s2==0)
    {
        String s4="1";
        for(int j=0;j<strnew.length();j++)
        {
            s4+="0";
        }
        return s4;
    }
    else{
        StringBuilder sb = new StringBuilder();
          for(int j=0;j<strnew.length();j++)
          {
              if(strnew.charAt(j)=='0') 
                  sb.append("1");
              else if(strnew.charAt(j)=='1') 
                  sb.append("0");
          }
          String s1 = sb.toString();
          int s = Integer.parseInt(s1, 2);//parse int radix = 2 for binary
          s++; //increment by one
        return Integer.toBinaryString(s);
    }
}