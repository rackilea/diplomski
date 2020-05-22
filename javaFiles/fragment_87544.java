if(ArrayList1.size() >= ArrayList2.size())
{
    // Here, ArrayList1.size() >= ArrayList2.size()
    // Use the smallest size as limit so we stay in bounds for both
    // In this case, that's ArrayList2.size()
    // When the lists have equal length, both sizes could be used
    // as limit so it doesn't really matter whether you use
    // > or >= in the test of the above if-statement
    for(int i=0; i<ArrayList2.size(); i++)
    {
        if(ArrayList1.get(i).equals(ArrayList2.get(i)))
        {
            temp++;
        }
    }
}
else
{
    // Here, ArrayList1.size() < ArrayList2.size()
    // so use ArrayList1.size() as the limit
    for(int i=0; i<ArrayList2.size(); i++)
    {
        if(ArrayList2.get(i).equals(ArrayList1.get(i)))
        {
            temp++;
        }
    }
}