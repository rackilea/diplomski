@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class MySpringTest {

    @MyAnnotation
    private UserSessionDAO dao;

    @Configuration
    static class TestContext {
        @Bean
        public static MyAnnotationPostProcessor myAnnotationPostProcessor() {
            return new MyAnnotationPostProcessor();
        }
    }

    @Test
    public void test() {

    }
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

}