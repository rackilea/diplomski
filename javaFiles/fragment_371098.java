public class ClaimItemSqlParameterSourceProvider implements ItemSqlParameterSourceProvider<ClaimLine> {

    @SuppressWarnings({ "serial"})
    @Override
    public SqlParameterSource createSqlParameterSource(final ClaimLine item) {
        return new MapSqlParameterSource(new HashMap<String, Object>() {
            {
                put("rxclaimid", item.getRxClaimID());
                ...
                // many more
            }
        });
    }
}