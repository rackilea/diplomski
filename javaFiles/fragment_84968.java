@Service
public class ParserService {

 @Autowired
 private ParserFactory parserFactory;

 public void doParse(String parseString, ParserType parseType) {
    Parser parser = parserFactory.getParser(parseType);
    System.out.println("ParserService.doParse.." + parser);
    parser.parse(parseString);
 }
}