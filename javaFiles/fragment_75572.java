@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:whereever/context.xml")
public class TestWarSpringContext {

    static {
        System.setProperty("myproperty", "foo");
    }

}