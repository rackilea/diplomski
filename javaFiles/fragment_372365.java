private static final String PERSON_QUERY;
private static final String ADDRESS_QUERY;
private static final String AGE_QUERY;

static{
    PERSON_QUERY = Helper.loadResourceToString("queries/personQuery.sql");
    ADDRESS_QUERY = Helper.loadResourceToString("queries/addressQuery.sql");
    AGE_QUERY = Helper.loadResourceToString("queries/ageQuery.sql");
}