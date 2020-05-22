boolean allTrue = true;
for (boolean b : booleanArray)
{
    if (!b)
    {
        allTrue = false;
        break;
    }
}