public void warn(String msg,Object arg0, Object arg1)
{
    String d=_dateCache.now();
    int ms=_dateCache.lastMs();
    synchronized(_buffer)
    {
        tag(d,ms,":WARN:");
        format(msg,arg0,arg1);
        System.err.println(_buffer.toString());
    }
}