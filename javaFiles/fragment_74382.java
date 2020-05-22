// Build a Mailjet client config
MailJetClientConfiguration config;

config = new MailJetClientConfiguration()
                .setBaseUrl("https://api.mailjet.com/v3/REST/")
                .setDefaultApiKey(System.getenv("MJ_PROD_PUBLIC"))
                .setDefaultSecretKey(System.getenv("MJ_PROD_PRIVATE"));

// Build a Mailjet client
MailJetApiClient client = config.buildClient();

// Your code (adapted to my environment, ie no 'Response' object 
// and no client factory.)
User thisUser = null;

try
{
    // Note that the 'L' in the 'identifiedBy' value fi is necessary
    thisUser = client
                .createCall(User.Get)
                .identifiedBy(UserProperty.ID, /*Our user's ID*/L)
                .execute();
}
catch (MailJetApiCallException e2)
{
    e2.printStackTrace();
}

String email = thisUser.getEmail();
String lastip = thisUser.getLastIp();
Date lastlogin = thisUser.getLastLoginAt();
String local = thisUser.getLocale();
String timezone = thisUser.getTimezone();
Date warned = thisUser.getWarnedRatelimitAt();

try
{
    thisUser = client
                .createCall(User.Update)
                .identifiedBy(UserProperty.ID, /*Our user's ID*/L)
                .property(UserProperty.USERNAME, "DevRel Team Mailjet")
                .execute();

}
catch (MailJetApiCallException e)
{
    e.printStackTrace();
}