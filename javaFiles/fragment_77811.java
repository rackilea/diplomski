interface Logger {
    void log(String message);
}

interface LoggerFactory {
    Logger getLogger(Object context);
}

@Component
class MyLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger(Object context) {
        return new Logger() {
            @Override
            public void log(String message) {
                System.out.println(context.getClass().getSimpleName() +
                                   " says '" + message + "'");
            }
        }
    }
}

@Component
class A {
    private Logger logger;

    @Inject
    public void setLogger(LoggerFactory factory) {
        this.logger = factory.getLogger(this);
    }
}