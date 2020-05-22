import org.springframework.context.support.ClassPathXmlApplicationContext;
    import com.company.auth.bean.Employee;

    public final class AuthServiceFactory {

        private static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "com/company/auth/service/cxfClient.xml" });

        public AuthServiceFactory() {
        }

        public AuthService getService() {
            return (AuthService) context.getBean("client");
        }

        public static void main(String[] args) {
            AuthServiceFactory authSer = new AuthServiceFactory();
            AuthService client = authSer.getService();
            Employee employee = client.getEmployee("22222");
            System.out.println("Server said: " + employee.getLastName() + " " + employee.getFirstName());
            System.exit(0);
        }
}