private String doubleNumber(String number)
{
    int doubleDig = 0;
    int carry = 0;

    StringBuilder sb = new StringBuilder();
    for (int i = number.length() - 1; i >= 0; --i)
    {
        char c = number.charAt(i);
        int origNum = Character.getNumericValue(c);
        doubleDig = origNum * 2 + carry;
        carry = doubleDig / 10;
        doubleDig = doubleDig % 10;

        sb.append(doubleDig);
    }
    if (carry > 0)
    {
        sb.append(carry);
    }

    return sb.reverse().toString();
}