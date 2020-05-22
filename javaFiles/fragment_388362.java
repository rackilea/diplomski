class Compare
{
Integer max;
Integer min;

public void max(int num)
{
    if (max == null) max = num;
    else if(num > max) max = num;
}

public void min(int num)
{
    if (min == null) min = num;
    else if(num < min) min = num;
}
}