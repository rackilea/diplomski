public class SomeOtherClass
{
    Connection conn;

    public SomeOtherClass (Connection conn) 
    {
        this.conn = conn;
    }

    protected void finalize() throws Throwable
    { 
        if (this.conn != null)
            conn.close();
    }

}