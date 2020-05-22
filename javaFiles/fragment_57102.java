@Aspect
public class LoggingAspect {

    private Logger log = Logger.getLogger(getClass());

    @Autowired
    public RequestScopeObject params;

    @Pointcut("within(net.company.dao..*)")
    private void clDaoLayer() {

    }

    private String uniqueIdentifier(){
       String uid = "";
       if (WorkThreadLocal.mwi != null) {
         uid = WorkThreadLocal.id.get() + " ";
       }
       return uid;
    }

    @Around("clDaoLayer()")
    public Object clDaoLayerAdvice(ProceedingJoinPoint joinPoint)
            throws Throwable {
        String TAG = uniqueIdentifier();
        // gets the system property dynamically for debugging purpose.
        this.printObject = Boolean.parseBoolean(System.getProperty("printobject"));
        Date start = new Date();
        String methodInExcecuting = getSignature(joinPoint);
        log.debug(TAG+"calling method.." + methodInExcecuting
                + " with arguments : " + Arrays.toString(joinPoint.getArgs()));
        Object result = null;
        String slug = "";
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error(TAG+" Exception .." + methodInExcecuting, e);
            throw e;
        }
        try {
            if (printObject == true) {
                if (result == null) {
                    slug = " null ";
                } else if (result instanceof List) {
                    slug = ((List) result).toString() + "\n"
                            + ((List) result).size() + "";
                } else if (result.getClass().toString().indexOf("[L") >= 0) {// if
                                                                                // array
                                                                                // get
                                                                                // length
                    slug = ArrayUtils.toString(result) + ". "
                            + ArrayUtils.getLength(result);
                } else if (result != null) {
                    slug = result.toString() + ". 1 value ";
                }
                slug += "\nvalues/rows returned.";
            } else {
                slug = "";
            }
        } catch (Exception e) {
            log.debug(TAG+"Error getting slug..");
        }
        Date end = new Date();
        log.debug(TAG+" Time taken: "
                + (end.getTime() - start.getTime()) + " milliseconds."+"returning from " + methodInExcecuting + ". " + slug);
        return result;
    }

}