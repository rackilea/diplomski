private Long startTime = null;
public Long counttime(int t)
{
    if(t==1)
        startTime = System.currentTimeMillis();
    if(t==2 && startTime != null)
    {
        long endTime   = System.currentTimeMillis();
        return endTime - startTime;
    }
    return null;
}