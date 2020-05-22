public class TestLogging {

public static void main(String[] args) {
    Logger logger = Logger.getLogger(A.class.getName());
    FormatHandler handler = new FormatHandler();
    logger.addHandler(handler);

    handler.addFormatter(new Formatter() {
        @Override
        public String format(LogRecord record) {
            return record.getMessage().replaceAll("method", "replacing method");
        }
    });

    handler.addFormatter(new Formatter() {
        @Override
        public String format(LogRecord record) {
            return record.getMessage().replaceAll("Logging", "replacing logging");
        }
    });
    logger.setUseParentHandlers(false);

    A a = new A();
    a.method();
}

public static class FormatHandler extends ConsoleHandler {

    private List<Formatter> formatters = new ArrayList<>();

    public FormatHandler() {
        setFormatter(new CompositeFormatter());
    }

    public void addFormatter(Formatter f) {
        formatters.add(f);
    }

    class CompositeFormatter extends Formatter {
        @Override
        public synchronized String format(LogRecord record) {
            String modifiedMessage;
            for(Formatter formatter : formatters){
                modifiedMessage = formatter.format(record);
                record.setMessage(modifiedMessage);
            }
            return record.getMessage();
        }
    }
}

public static class A {

    private static final Logger LOGGER = Logger.getLogger(A.class.getName());

    public void method() {
        LOGGER.info("\nLogging from inside method");
    }
    }
}