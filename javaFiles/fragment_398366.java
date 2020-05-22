while(st.hasMoreTokens())
{

    if(count==1)
    {
        e.ename=st.nextToken();
        count++;
    }
    if(count==2)
    {
        e.eno=st.nextToken();
        count=0;
    }
    a1.add(e);
}