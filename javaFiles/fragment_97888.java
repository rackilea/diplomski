public String getValue()
{
    Proxy proxy = getProxy(this);
    return (String)proxy.invoke("getValue", new Object[] { });
    // this is all just an example,
    // it's defintely way more complicated than this
}