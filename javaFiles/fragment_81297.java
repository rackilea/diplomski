@Singleton
public class LoggerProducer {

    // here perhaps a cache or environment related flags, ...

    @Security
    @Produces
    public Logger getSecurityLogger(InjectionPoint ip) {
        String key = getKeyFromIp(ip);
        return new SecurityLoggerImpl(key);
    }

    @SystemError
    @Produces
    public Logger getSystemErrorLogger(InjectionPoint ip) {
        String key = getKeyFromIp(ip);
        return new SystemErrorLoggerImpl(key);
    }

    private String getKeyFromIp(InjectionPoint ip) {
        return ip.getMember().getDeclaringClass().getCanonicalName();
    }

}