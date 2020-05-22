public class LoginFactory {

    private static class AuditInvocationHandler implements InvocationHandler {

        private final Login realLogin;

        public AuditInvocationHandler(Login realLogin) {
            this.realLogin = realLogin;
        }

        public Object invoke(Object proxy, Method method, Object[] args) 
                      throws Throwable {
            Method realMethod = realLogin.getClass().getMethod(
                                        method.getName(), 
                                        method.getParameterTypes());
            Audit audit = realMethod.getAnnotation(Audit.class);

            if (audit != null) {
                audit.handler().newInstance().handle();
            }

            return method.invoke(realLogin, args);
        }
    }

    public static Login createLogin() {
        return (Login) Proxy.newProxyInstance(
                LoginFactory.class.getClassLoader(),
                new Class[]{Login.class},
                new AuditInvocationHandler(new LoginImpl()));
    }
}