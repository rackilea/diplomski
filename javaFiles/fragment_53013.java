@AllArgsConstructor
@RunWith(Parameterized.class)
public class HtmlActionInjectTest {
    @Parameters(name="{1}")
    public static List<Object[]> parameters() {
        return ImmutableList.of(classesUnderTest);
    }

    @BeforeClass
    public static void setUp() {
        bindings = Guice.createInjector(Stage.TOOL, myLongListOfModules).getAllBindings().keySet();
    }

    private static Set<Key<?>> bindings;
    private final Class<?> actionClass;

    @Test
    public void test() {
        for (InjectionPoint point : InjectionPoint.forInstanceMethodsAndFields(actionClass)) {
            for (Dependency<?> dependency : point.getDependencies()) {
                assertTrue("injector cannot satisfy dependency " + dependency.getKey() + " in " + actionClass.getName(), bindings.contains(dependency.getKey()));
            }
        }
    }
}