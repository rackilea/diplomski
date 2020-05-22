public class CertificateLM extends AppservCertificateLoginModule
{

    protected void authenticateUser() throws LoginException
    {
        // get the DN from the X500Principal.
        String dname = getX500Principal().getName();

        // retrieve the groups of the DN from an external source, e.g. from LDAP
        String[] groups = getGroupsFromLDAP( dname ); 

        if( groups != null ) {
             commitUserAuthentication( groups );
        }
        else {
             throw new LoginException( "DN is unknown." );
        }
    }
}