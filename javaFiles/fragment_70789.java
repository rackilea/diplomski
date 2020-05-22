public class EntityTest {

    private JavaClasses classes;

    @Before
    public void setUp() {
        classes = new ClassFileImporter().importPackages("org.my.company");
    }

    @Test
    public void classesAnnotatedAsEntitiesShouldResideInEntitiesPackage() {
        ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAnyPackage("..entities")
            .check(this.classes);
    }
}