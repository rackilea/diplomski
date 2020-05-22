public static void main(String[] args) {
    System.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.1.3");
    System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
    InitialContext ctx = new InitialContext();
    TestentityFacadeRemote tfr = (TestentityFacadeRemote)ctx.lookup("java:global/TestEE/TestEE-ejb/TestentityFacadeRemote!com.acme.remote.TestentityFacade");
}