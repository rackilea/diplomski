@RunWith(SpringJUnit4ClassRunner.class)
public class FooTest{

    Foo foo;
    @Value("${myProp}") 
    String myProp;

    @BeforeEach
    public void beforeEach(){
       foo = new Foo(myProp);
    }
}