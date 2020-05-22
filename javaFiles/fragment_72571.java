public class AccessDeniedExceptionWithConfigAttributes extends AccessDeniedException
{
private static final long   serialVersionUID    = 8733424338864969263L;

private Collection<ConfigAttribute> configAttributes;

public AccessDeniedExceptionWithConfigAttributes (String msg)
{
    super(msg);
}

public AccessDeniedExceptionWithConfigAttributes (String msg, Throwable t)
{
    super(msg, t);
}

public AccessDeniedExceptionWithConfigAttributes (String msg, Collection<ConfigAttribute> configAttributes)
{
    super(msg);
    this.setConfigAttributes(configAttributes);
}

public Collection<ConfigAttribute> getConfigAttributes()
{
    return configAttributes;
}

public void setConfigAttributes(Collection<ConfigAttribute> configAttributes)
{
    this.configAttributes = configAttributes;
}