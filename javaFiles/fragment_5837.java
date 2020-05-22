package test.package
@Plugin(name = "AccessLog", category = "Core", elementType = "appender")
public final class AccessLogAppender extends AbstractAppender
{
    private static final long serialVersionUID = 1L;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock ();
    private final Lock readLock = rwLock.readLock ();

    private Connection connection = null;

    protected AccessLogAppender (final String name)
    {
        super (name, null, null);
    }
    private void init() {
if(connection == null) {
    try
        {   

                connection = // code snippet to get the DB Connection 

        }
        catch (SQLException e)
        {

        }
     }
}

    @PluginFactory
    public static AccessLogAppender createAppender (
            @PluginAttribute("name") String name)
    {
        return new AccessLogAppender (name);
    }

    @Override
    public void append (LogEvent event)
    {
        init();
        readLock.lock ();

        PreparedStatement ps = null;

        try
        {
            // code snippet to save the log into the DB

        }
        catch (SQLException e)
        {

        }
        finally
        {
            readLock.unlock ();
        }
    }

    @Override
    public void stop ()
    {
        if (connection != null)
        {
            try
            {
                connection.close ();
            }
            catch (SQLException e)
            {
                System.out.println (e.getMessage ());
            }
        }
    }
}