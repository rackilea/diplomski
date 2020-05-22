@Service
public class ParsingService {

    private final Map<String, Parser> parsers;

    @Autowired
    public ParsingService(List<Parser> allParsers) {
        this.parsers = allParsers
                           .stream()
                           .collect(Collectors.toMap(Parser::getFormat, p -> p));
    }

    public List<Order> parse(String filePath) {
        try {
            String format = getFormat(filePath);
            Parser parser = parsers.get(format);
            if(parser == null) {
                // Replace this exception by a more appropriate one
                throw new RuntimeException("No parsers found for format : " + format);
            } else {
                return parser.parse(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFormat(String filePath){
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            return filePath.substring(i+1).toLowerCase();
        } else {
            // Replace this exception by a more appropriate one
            throw new RuntimeException("Cannot determine the file format!");
        }   
    }
}