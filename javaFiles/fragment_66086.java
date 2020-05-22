public class StackOverflowTest {

    @Test
    public void testName() throws Exception {

        Annotation[] annotations = Obj.class.getDeclaredField("myField").getAnnotations();

        System.out.println(annotations[0]);
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Searchable {

}

class Obj {

    @Searchable
    String myField;
}