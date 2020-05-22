public class UserService  extends  UserLocalServiceWrapper
{

@Override
    public int authenticateByScreenName(long companyId, String screenName, String password, Map headerMap, Map parameterMap, Map resultsMap)
    {
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