@Deployment    
public static WebArchive createDeployment() {
    WebArchive war = ShrinkWrap.create(WebArchive.class)
        .addPackages(true, Appointment.class.getPackage(), AppointmentsFacadeREST.class
        .getPackage(), ClassConstraints.class.getPackage())
        .setWebXML("test-web.xml")
        .addAsManifestResource("test-context.xml", "context.xml")
        .addAsManifestResource("test-persistence.xml", "persistence.xml")
        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
        .addAsResource("test-login.config", "login.config")
        .addAsResource("users.properties")
        .addAsResource("groups.properties");
    return war;
}