@Aspect
@Component
public class ControllerMonitor {

    protected static  final Logger LOGGER = LoggerFactory.getLogger(ControllerMonitor.class);


    @Before("execution(public * com.demo.controller.*Controller.*(..))")
    public void logBeforeAccess(JoinPoint joinPoint) {
        if(joinPoint!=null){
            String packageName = joinPoint.getSignature()!=null?joinPoint.getSignature().getDeclaringTypeName():"LOG-404";
            LOGGER.info(". . .A request initiated from controller [" + packageName + "."+ getMethodSignature(joinPoint) +  "]. . .");
        }

    }

    @After("execution(public * com.demo.controller.*Controller.*(..))")
    public void logAfterAccess(JoinPoint joinPoint) {
        if(joinPoint!=null){
            String packageName = joinPoint.getSignature()!=null?joinPoint.getSignature().getDeclaringTypeName():"LOG-404";
            LOGGER.info(". . .Request from controller [" + packageName + "."+ getMethodSignature(joinPoint) +  "] completed. . .");
        }
    }

    @AfterThrowing(pointcut = "execution(public * com.demo.controller.*Controller.*(..))",throwing="exception")
    public void logAfterThrowing(Exception exception){
        LOGGER.error("Exception caught:"+ exception.getMessage());
    }

    private String getMethodSignature(JoinPoint joinPoint){
        if(joinPoint!=null){
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            StringBuilder sb=new StringBuilder();
            if(arguments!=null){
                for (Object param: arguments) {
                    sb.append(param).append(",");
                }
                sb =(sb.length()>1)?sb.deleteCharAt(sb.length()-1):sb;
            }
            methodName = methodName+"("+new String(sb)+")";
            return methodName;
        }else{
            return "LOG-405";
        }
    }
}