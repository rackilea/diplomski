@Deployment
    public static Archive<?> createDeployment() {
        final JavaArchive ejbJar = ShrinkWrap
                .create(JavaArchive.class, "ejb-jar.jar")
                .addClass(NewSessionBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        final WebArchive testWar = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(NewSessionBeanTest.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")

                ;

        Archive[] libsArchives = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-all")
                .withTransitivity()
                .as(JavaArchive.class);

        testWar.addAsLibraries(libsArchives);
        final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
                .setApplicationXML("META-INF/test-application.xml")
                .addAsModule(ejbJar)
                .addAsModule(testWar);

        return ear;
    }