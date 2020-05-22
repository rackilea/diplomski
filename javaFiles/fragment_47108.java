if (temp.equals(" "))
{
    regex = regex + "[a-z]";
}
else if (temp.length() > 0)
{
    String s = "[" + temp + "]";
    regex = regex + s;
}