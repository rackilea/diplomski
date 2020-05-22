@Override
public void addHeader(String name, String val)
{
    if ( "Content-Length".equalsIgnoreCase(name) ) 
    {
        // Ignore content-length from servlets
        return;
    }
    super.addHeader(name,val);
}