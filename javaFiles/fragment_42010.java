@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestFactoryMethodConfig.class})
public class TestFactoryMethod {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource(name = "stringMaker1")
    private StringMakerInterface stringMaker1;

    @Resource(name = "stringMaker2")
    private StringMakerInterface stringMaker2;

    @Test
    public void testFactoryMethodUsage() {

        StringPrinter stringPrinter1 = (StringPrinter) applicationContext.getBean("stringPrinter", stringMaker1);

        StringPrinter stringPrinter2 = (StringPrinter) applicationContext.getBean("stringPrinter", stringMaker2);

        stringPrinter1.printString();
        stringPrinter2.printString();
    }

}