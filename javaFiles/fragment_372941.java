public static String customizedReverse(String str, int param)
{
    String result = "";
    boolean reverse = false;
    StringBuilder sb = null;
    int size = str.length(), i = 0;

    if(param > size)
        return str;

    for (i = 0; i < (size/param)*(param); i += param)
    {
        String temp = str.substring(i, i + param);
        if (!reverse)
            result += temp;
        else
        {
            sb = new StringBuilder(temp);
            result += sb.reverse();
        }
        reverse = !reverse;
    }
    // Appending the remaining part of the string       
    if (!reverse)
        result += str.substring(i, size);
    else
    {
        sb = new StringBuilder(str.substring(i, size));
        result += sb.reverse();
    }

    return result;
}