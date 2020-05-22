public class CompositeQuery implements Query {

    private final List<Query> queries;

    public CompositeQuery( Query... queries ) {
        this.queries = Arrays.asList(queries);
    }

    @Override
    public EnumSet<Term> getTerms() {
        Set<Term> result = new HashSet<>();
        for( Query query : queries ) {
            result.addAll(query.getTerms());
        }
        return EnumSet.copyOf(result);
    }
}