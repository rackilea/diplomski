public class ObjectWrapper
{
    private final Object obj;
    private final long expireTime;

    public ObjectWrapper(Object obj, long expireTime)
    {
        this.obj = obj;
        this.expireTime = expireTime;
    }

    public Object getObj()
    {
        return obj;
    }

    public long getExpireTime()
    {
        return expireTime;
    }
}