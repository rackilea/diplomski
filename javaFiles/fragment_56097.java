public class SomeInterceptor implements Interceptor {
    private static final long serialVersionUID = 1L;
    @Override
    public String intercept(ActionInvocation invocation) {
        String result = "";
        GenericDAO dao = new GenericDAO();
        try {
            dao.begin();
            invocation.getInvocationContext().put("contextDao", dao);
            result = invocation.invoke();
            dao.rollback();
        } catch (Exception ex) {
            dao.rollback();
            System.out.println("ROLLBACK!");
            ex.printStackTrace();
        } finally {
            dao.close();
        }
        return result;
    }
}