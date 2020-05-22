@ContextConfiguration(classes = ConfigExample.class)
@RunWith(MockitoJUnitRunner.class)
public class Example {
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    private Foo foo;

    @Mock
    private Runnable runnable;

    @Test
    public void method2() {
        Mockito.doNothing().when(runnable).run();
        foo.bar(runnable);
        Mockito.verify(runnable).run();
    }
}

@Configuration
class ConfigExample {
    @Bean
    public Foo Foo() {
        return new Foo();
    }
}

class Foo {
    public void bar(Runnable invoke) {
        invoke.run();
    }
}