while (st.hasMoreTokens())
{
    for (i=0; i<size; i++)
    {
        test[i] = st.nextToken();
        c[i].SetCount(1, test[i]);
    }
}