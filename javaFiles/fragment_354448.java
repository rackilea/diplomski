@Deployment
public static Archive<?> createDeployment()
{
    File[] files = Maven.resolver().resolve("mysql:mysql-connector-java:8.0.11").withTransitivity().asFile();
    WebArchive archive =ShrinkWrap.create(WebArchive.class, "morphological-analysis-data-access-object-test.war")
        .addPackages(true,"com.root")
        .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
        .addAsLibraries(files);
    archive.as(ZipExporter.class).exportTo(new File("/" + archive.getName()), true);
    return archive;
}