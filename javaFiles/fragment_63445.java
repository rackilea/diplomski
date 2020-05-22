public class Receiver {

    int in;

    public Receiver() {
    }

    public Receiver(int in) {
        this.in = in;
    }

    private static int extractValue(InjectionPoint ip) {
        for (Annotation annotation : ip.getQualifiers()) {
            if (annotation.annotationType().equals(SendInject.class))
                return ((SendInject) annotation).value();
        }
    }

    @Produces
    @SendInject
    public static Receiver createSendInjectReceiver(InjectionPoint ip) {
        int in = extractValue(ip);
        return new Receiver(in);
    }
}