public class AssetAvailabilityRefRowMapper implements RowMapper {
    @Override
    public AssetAvailabilityRef mapRow(ResultSet rs, int arg1) throws SQLException {
        AssetAvailabilityRef assetAvailabilityRef = new AssetAvailabilityRef();
        assetAvailabilityRef.setSourceCode(rs.getString("source_asset_availability"));
        assetAvailabilityRef.setDestinationCode(rs.getString("dest_asset_availability"));
        assetAvailabilityRef.setLoadType(rs.getInt("load_type"));
        return assetAvailabilityRef;
    }
}

public List<AssetAvailabilityRef> getAssetAvailabilityRef() {
    return (List<AssetAvailabilityRef>) this.jdbcTemplate.query(
                                             MaintenanceLdrDao.assetAvailabilityRefQuery,
                                             new AssetAvailabilityRefRowMapper());
}