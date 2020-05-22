static int MAX_BITS = 8;
static int MAX_INT = (int)Math.pow(2, MAX_BITS) - 1;

public static int complimentDecimal(int num)
{
    // check if number is to high for the bitmask
    if(num > MAX_INT){
        System.out.println("Number=" + num + " to high for MAX_BITS="+MAX_BITS);
        return -1;
    }

    // Your conversion works!
    int p=0;
    String s1="";
    //Convert Decimal to Binary
    while(num>0)
    {
        p=num%2;
        s1=p+s1;
        num=num/2;
    }

    // fill starting zeros to match MAX_BITS length
    while(s1.length() < MAX_BITS)
        s1 = "0" + s1;

    System.out.println(s1);

    //Replace the 0s with 1s and 1s with 0s

    // your approach on that is very wrong
    StringBuilder sb = new StringBuilder();
    for(int j=0;j<s1.length();j++){
        if(s1.charAt(j)=='0') sb.append("1");
        else if(s1.charAt(j)=='1') sb.append("0");
    }
    s1 = sb.toString();

    /*
    for(int j=0;j<s1.length();j++)
    {
        if(s1.charAt(j)==0)
        {
            s1.replace(s1.charAt(j),'1');
        }
        else
        {
            s1.replace(s1.charAt(j),'0');
        }

    }
    */
    System.out.println(s1);

    int decimal=0;
    int k=0;
    for(int m=s1.length()-1;m>=0;m--)
    {
        // you don't want the char code here but the int value of the char code
        //decimal += (s1.charAt(m) * Math.pow(2, k));
        decimal+=(Character.getNumericValue(s1.charAt(m))*Math.pow(2, k));

        k++;
    } 
    return decimal;
}