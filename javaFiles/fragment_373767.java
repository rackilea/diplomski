long a0long = a0.getID();
long a1long = a1.getID();
if (a0long < a1long)
{
    return -1;
}

return a0long == a1long ? 0 : 1;