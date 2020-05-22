public class EchoServiceClient {

    public static void main(String[] args) {
        try {

            System.setProperty("java.security.policy", "/java.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            Registry registry = LocateRegistry.getRegistry("localhost");

            EchoServiceFactory serviceFactory =
                    (EchoServiceFactory) registry.lookup("EchoService");
            EchoService echoServiceX = serviceFactory.createEchoService();
            echoServiceX.setUser("Tom");
            System.out.println(echoServiceX.echo("Hello!"));
            EchoService echoServiceY =
                    serviceFactory.createEchoService();
            echoServiceY.setUser("Jerry");
            System.out.println(echoServiceY.echo("Hello"));
            System.out.println(echoServiceX.echo("Hey There!!!"));
            System.out.println(echoServiceY.echo(":o)"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}