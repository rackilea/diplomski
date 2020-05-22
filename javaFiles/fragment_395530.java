public class MyFilter implements Filter {
    public boolean isLoggable(LogRecord record) {
        return "org.hibernate.orm.deprecation".equals(record.getSourceClassName()) 
            && record.getMessage().contains("HHH90000014") ? false : true;
    }
}