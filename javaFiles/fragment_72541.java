@Deployment(testable = true, managed = true)
public static JavaArchive createDeployment() {

    TestJavaClassTreeConstruct.getEjbAnnotatedClassTree(ExportTagsResource.class);
    JavaArchive jar = ShrinkWrap.create(JavaArchive.class);


    for (Class c : TestJavaClassTreeConstruct.getEjbAnnotatedClassTree(MyMainClass.class)) {
        jar.addClass(c);
    }
    jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    System.out.println(jar.toString(true));

    return jar;
}