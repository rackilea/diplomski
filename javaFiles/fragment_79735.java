public class CustomJdbcRealm extends JdbcRealm 
{
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException 
    {

       AuthenticationInfo  info = super.doGetAuthenticationInfo(token);
      // Your own code here 
    }
}