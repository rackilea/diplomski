abstract class MyAbstractClass {
    protected final Logger log;
    MyAbstractClass(String foodType) {
        MDC.put("myfood", foodType);
        this.log = LoggerFactory.getLogger(getClass()));
    }
}