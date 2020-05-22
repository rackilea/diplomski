@Aspect
@Component
public class InterceptRestAnnotationAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerExecution() {}


    @Before("restControllerExecution()")
    public void setMetodoHttpHeader(JoinPoint joinPoint) throws Throwable {

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getResponse();

        String origem = VerificadorOrigem.processarOrigem(joinPoint);

        response.setHeader("nomeMetodo", origem);

    }

}