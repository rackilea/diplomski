/**
 * This service aggregates the default CookieManager as explained in the API 
 * (http://docs.oracle.com/javase/6/docs/api/java/net/CookieManager.html). 
 * A system-wide CookieManager that is used by the HTTP protocol handler 
 * can be retrieved by calling CookieHandler.getDefault(). 
 * A CookieManager is initialized with aآ CookieStoreآ which manages storage
 * A CookieStore supports add(cookie) and getCookie() methods
 * A CookieStore is responsible of removing Cookie instances which have expired.
 *
 */
@Service(value="serviceConfigBean")
@DependsOn(value="cookieHandlerSetDefault")    //This is the bean initialized in the Configuration class. It is needed to be initialized before the container initializes the Service 
public class ClientCookiesStore {

    private static final Logger logger = LoggerFactory.getLogger(ClientCookiesStore.class);

    protected CookieStore inmemoryCookieStore;

    protected URI clientURI;

/**
 * The @PostConstruct (lifecycle callback method) indicates this method should be invoked after all 
 * dependency injection is complete. Thus helps in initializing any resources needed by the 
 * service.
 * 
 * In this particular initializing method:
 * (as per http://docs.oracle.com/javase/6/docs/api/java/net/CookieManager.html
 *  and http://docs.oracle.com/javase/tutorial/networking/cookies/cookiemanager.html)
 * The CookieHandler default is installed in the application via 
 * a method invoking factory bean, namely "cookieHandlerSetDefault" which 
 * exists in the java configuration file WebConfig.java

 * (1) A cookieManager property needs 2 steps setup as indicated in the code
 * (2) The internal in-memory implementation of the CookieStore interface is initialized 
 *      through the cookieManager defaults. It is assigned to the inmemoryCookieStore property.  
 * (3) Since a CookieStore aggregates many groups of cookies, each group is identified 
 *     by a URI instance. ClientCookiesStore is associated with the Client URI as indicated in 
 *     the code.  
 * 
 * @throws Exception
 */
@PostConstruct
protected void initializeBean() throws Exception {
    //      (1) Step#1 Initialize a CookieManager with the current Http session default 
    //                  which was already set in the configuration class
    CookieManager cookieManager = (CookieManager)CookieHandler.getDefault();    
    //          Step#2 Then set up the CookiePolicy.
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    //      (2) Assign a CookieStore instance to the in-memory cookie store implemented by the API
    inmemoryCookieStore =  cookieManager.getCookieStore();
    //      (3) Initialize URI instance which will identify the Client cookies in the CookieStore 

    try {
        clientURI = new URI("http://vendor.webservices.com/endpoint");
    } catch (URISyntaxException e) {
        throw new Exception("URISyntaxException created while creating a URI instance for url= "+clientUrl);
    }
}