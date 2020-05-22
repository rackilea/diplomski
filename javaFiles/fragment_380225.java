public class bugzillaTest {


private static final String COMP = "Usability";
private static final String DES = "this is a test desc";
private static final String OS = "All";
private static final String PLAT = "PC";
private static final String PRIO = "High";
private static final String PRO = "MMNR7";
private static final String SUM = "test summary";
private static final String VER = "1.0";





public static void main(String args[]) throws Exception {

    // try to connect to bugzilla

    BugzillaConnector conn;
    BugFactory factory;
    Bug bugs;
    ReportBug report;

    conn = new BugzillaConnector();


    conn.connectTo("http://192.168.0.31/");

    LogIn login = new LogIn("username", "password");


    // create a bug

     factory = new BugFactory();
     bugs = factory
                .newBug().
     setOperatingSystem(OS)
        .setPlatform(PLAT)
        .setPriority(PRIO)
        .setProduct(PRO)
        .setComponent(COMP)
        .setSummary(SUM)
        .setVersion(VER)
        .setDescription(DES)
        .createBug();


     report=new ReportBug(bugs);




try{conn.executeMethod(login);
conn.executeMethod(report);

}
catch(Exception e){System.out.println(e.getMessage());}


}


}