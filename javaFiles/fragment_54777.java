public class TestCRM {  

private static String endpointURL = "http://server:port/MSCrmServices/2007/CrmService.asmx";  
private static String userName = "username";  
private static String password = "password";  
private static String host = "server";  
private static int portport = port;  

//To make sure you are using the correct domain open ie and try to reach the service. The same domain you entered there is needed here  
private static String domain = "DOMAIN";   

private static String orgName = "THIS_IS_REQUIRED"; //this does the work....  


public static void main(String[] args) {  

    CrmServiceStub stub;  
    try {  
        stub = new CrmServiceStub(endpointURL);  
        setOptions(stub._getServiceClient().getOptions());  

        RetrieveMultipleDocument rmd = RetrieveMultipleDocument.Factory.newInstance();  
        RetrieveMultiple rm = RetrieveMultiple.Factory.newInstance();  

        QueryExpression query = QueryExpression.Factory.newInstance();  
        query.setColumnSet(AllColumns.Factory.newInstance());  
        query.setEntityName(EntityName.######.toString());  
        //query.setFilter...  

        rm.setQuery(query);  
        rmd.setRetrieveMultiple(rm);  

        //Now this is required. Without it all i got was 401s errors  
        CrmAuthenticationTokenDocument catd = CrmAuthenticationTokenDocument.Factory.newInstance();  
        CrmAuthenticationToken token = CrmAuthenticationToken.Factory.newInstance();  
        token.setAuthenticationType(0);     
        token.setOrganizationName(orgName);  
        catd.setCrmAuthenticationToken(token);  

        boolean fetchNext = true;  
        while(fetchNext){  
            RetrieveMultipleResponseDocument rmrd = stub.RetrieveMultiple(rmd,  catd, null, null);  
            RetrieveMultipleResponse rmr = rmrd.getRetrieveMultipleResponse();  
            BusinessEntityCollection bec = rmr.getRetrieveMultipleResult();  

            String pagingCookie = bec.getPagingCookie();  
            fetchNext = bec.getMoreRecords();  

            ArrayOfBusinessEntity aobe = bec.getBusinessEntities();  
            BusinessEntity[] myEntitiesAtLast = aobe.getBusinessEntityArray();  

            for(int i=0; i<myEntitiesAtLast.length; i++){  
                //cast to whatever you asked for...  
                ### myEntity = (###) myEntitiesAtLast[i];  
            }  
        }  
    }   
    catch (Exception e) {  
        e.printStackTrace();  
    }  
}  

private static void setOptions(Options options){  
    HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();  

    List authSchemes = new ArrayList();  
    authSchemes.add(HttpTransportProperties.Authenticator.NTLM);   
    auth.setAuthSchemes(authSchemes);   

    auth.setUsername(userName);  
    auth.setPassword(password);  
    auth.setHost(host);  
    auth.setPort(port);  
    auth.setDomain(domain);  
    auth.setPreemptiveAuthentication(false); //it doesnt matter...  
    options.setProperty(HTTPConstants.AUTHENTICATE, auth);  
    options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true"); //i think this is good.. not required though  
}