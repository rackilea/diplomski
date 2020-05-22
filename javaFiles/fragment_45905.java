@RunWith(Arquillian.class)
public class MyTest {

    @Deployment
    public static Archive<?> deployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
            .addClass(com.real.EJB1.class)
            .addClass(com.example.mock.EJB2.class)
        ;
    }

    // ..
}