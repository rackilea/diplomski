public class RibeiraoVisitorRule extends AbstractExtractionRules<Document, String> {

    @Override
    public List<String> extract(String htmlCode) {
        ...
        Document doc = getParserAPI().parseDocument("");
    }