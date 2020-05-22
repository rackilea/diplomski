for (int i = 0; i < str.length(); i++)
{
    char c = str.charAt(i);

    if (Character.isDigit(c))            
        num.push((double) (c - '0'));

    else if (c == '+')         
        op.push("+");

    System.out.println(str);
}