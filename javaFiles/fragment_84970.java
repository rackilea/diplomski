@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ServiceLocatorFactoryExample {


 @Autowired
 private ParserService parserService;

 @Test
 public void testParserFactory() {
    parserService.doParse("Srilekha", ParserType.JSON);
    parserService.doParse("Srilekha", ParserType.XML);
 }
}