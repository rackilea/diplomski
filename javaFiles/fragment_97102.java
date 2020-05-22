final Map<Integer, String> colorMap = new LinkedHashMap<Integer, String>();
getJdbcTemplate().query(query, new RowCallbackHandler() {
    @Override
    public void processRow(ResultSet rs) {
        colorMap.put(rs.getInt("ID"), rs.getString("color_name"));
    }
});