public class CaseQueryExtractor extends Extractor {

    protected int beforeHandle(Request request, Response response) {
        extractFromQuery("offset", "offset", true);
        extractFromQuery("limit", "limit", true);

        // Stuff happens...

        CaseQuery query = new CaseQuery();

        Map<String,Object> attributes = request.getAttributes();
        attributes.put("query", query);
        return CONTINUE;
    }
}