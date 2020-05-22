public class SomeInterceptor {
    @Resource
    private javax.ejb.SessionContext sessionContext;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        if (isCMT()) {

        }
        ...
    }

    private boolean isCMT() {
        try {
           //throws IllegalStateException if not BMT
           sessionContext.getUserTransaction();
           return false;
        }
        catch (IllegalStateException ise) {
           return true;
        }
    }
}