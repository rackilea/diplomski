@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest{

    private ApplicationContext applicationContext;

    @Before
    public void init(){
        this.applicationContext = 
            new AnnotationConfigApplicationContext(MyBeans.class);

            //not necessary if MyBeans defines a bean for MyCommand
            //necessary if you need MyCommand - must be annotated @Component
            this.applicationContext.scan("package.where.mycommand.is.located");
            this.applicationContext.refresh(); 

        //get any beans you need for your tests here
        //and set them to private fields
    }

    @Test
    public void fooTest(){
        assertTrue(true);
    }

}