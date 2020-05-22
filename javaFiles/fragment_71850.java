public static int getMaxPosition(ArrayList<Integer>list)
{
    int max=list.get(0);
    int maxPos=0;
    int curr;
    int c;
    for (c=0; c<list.size(); c++)
    {
        curr=list.get(c);
        if (curr>max)
        {
            maxPos=curr;
            max=curr;
        }
    }

    return maxPos;
}