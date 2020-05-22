@Deployment
public static WebArchive createJavaTestArchive() throws IOException {
    WebArchive war = ShrinkWrap.create(WebArchive.class)
        .addPackages(
                true,
                "x.y.z.acme",
                "javax.persistence" // Tomee does not contain JPA2.1
        )
    ;
    File beansXml = new File("src/main/resources/META-INF/beans.xml");
    war.addAsManifestResource(beansXml, "beans.xml");
    File persistenceXm = new File("src/test/resources/test-persistence.xml");
    war.addAsResource(persistenceXm, "META-INF/persistence.xml");
    war.addAsResource(new File("src/main/resources/import.sql"));
    File[] libs = Maven.resolver().loadPomFromFile("pom.xml")
            .importRuntimeDependencies().resolve().withTransitivity().asFile();
    war.addAsLibraries(libs);
    System.out.print(war.toString(true));
    return war;
}