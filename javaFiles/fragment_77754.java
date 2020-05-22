@Aspect
@Component
@Slf4j
public class MetricsAspect {

    @Pointcut("execution(* javax.servlet.http.HttpServlet.*(..)) *)")
    public void servletService() {
    }

    @Autowired
    Tracer tracer;

    @Around("servletService()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        long inicioProcesso = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long finalProcesso = System.currentTimeMillis();

        long duracaoProcesso = finalProcesso - inicioProcesso;

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getResponse();

        Metrics metricas = new Metrics();

        String funcionalidade = response.getHeader("nomeMetodo") == null ? "Indeterminada"
                : response.getHeader("nomeMetodo");

        metricas.setNivelLog("INFO");
        metricas.setFuncionalidade(funcionalidade);
        metricas.setDuracaoMs(duracaoProcesso);
        metricas.setDataHoraRequisicao(ManipulaData.milissegundosToStringDate(inicioProcesso));
        metricas.setDataHoraResposta(ManipulaData.milissegundosToStringDate(finalProcesso));
        metricas.setServidorOrigem(request.getRemoteAddr());
        metricas.setPortaOrigem(request.getRemotePort());
        metricas.setDominioAcesso(request.getLocalName());
        metricas.setPortaAcesso(request.getLocalPort());
        metricas.setUrlPath(request.getRequestURI());
        metricas.setMetodoHttp(request.getMethod());
        metricas.setIdTransacao(tracer.currentSpan().context().traceIdString());
        metricas.setIdSpan(tracer.currentSpan().context().spanIdString());
        metricas.setStatusHttp(response.getStatus());

        log.info(JSONConversor.toJSON(metricas));

        return result;

    }
}