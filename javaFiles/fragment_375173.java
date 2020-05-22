public class Authenticator
{
    private String name;

    public Authenticator( String name )
    {
        this.name = name;
    }

    public void authenticate( Object subject )
    {
        System.out.println( subject + " is being authenticated by: " + name );
    }
}