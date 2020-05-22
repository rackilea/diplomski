public class PersonClassExtractor extends ClassExtractor {
    @Override
    public Class<?> extractClassFromRow(Record databaseRow, Session session) {
        if (databaseRow.containsKey("CLIENT_SPECIFIC")) {
            return Client.class;
        } else if (databaseRow.containsKey("AFFILIATE_SPECIFIC")) {
            return Affiliate.class;
        } else {
            return Person.class; // this should never happen
        }
    }
}