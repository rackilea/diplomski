/**
 * Java global JNDI.
 */
private static final String JAVA_GLOBAL = "java:global/";

/**
 * Application name in application server.
 */
private static final String APP_NAME = "YourAppName/";

/**
 * Application EJB jar name.
 */
private static final String APP_EJB = "your-ejb/";

/**
 * Credit EJB constant.
 */
public static final String CREDIT_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB + "CreditcardFacade!your.package.CreditcardFacadeLocal";