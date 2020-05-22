tp: for (;;)
{
    i++;
    for (;;)
    {
        if (i > --j) {
            break tp;
        }
    }
}
System.out.println("i =" + i + ", j = " + j);