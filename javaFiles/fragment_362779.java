public class CustomAuthenticator implements Authenticator
{
    @Override
    public int authenticateByScreenName(long companyId, String screenName, String password,
            Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {



    //Call external system to authenticate 
    if(externalAuthenticationSuccess)
    {
        return Authenticator.SUCCESS;
    }
    else
    {
        return Authenticator.FAILURE; 
    } 


    }
}