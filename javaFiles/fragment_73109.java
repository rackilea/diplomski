boolean allZero = true;
for (int i=0;i<value.length() && allZero;i++)
{
    if (value.charAt(i)!='0')
        allZero = false;
}
if (allZero)
    return "0"
...The code you already have