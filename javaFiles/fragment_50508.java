public JSONArray getObjectsJsonArrayByCountryCodeAndDestination(String countryCode, String destinationCountryStartingLetter)
        throws JSONException, UnsupportedEncodingException {
    String query = "select * from EMBASSY where COUNTRY_CODE = ? AND DESTINATION LIKE '"+destinationCountryStartingLetter+"%' order by DESTINATION";
    jdbcTemplate = new JdbcTemplate(dataSource);
    List<Embassy> list = jdbcTemplate.query(query,
            new Object[] { countryCode }, new EmbassyMapper());
    JSONArray jsonArray = new JSONArray();
    if (list.isEmpty()) {
        return jsonArray;
    } else {
        for (Embassy embassy : list) {
            String address = new String(embassy.getAddress().getBytes("UTF-8"), "UTF-8");
            String address2 = embassy.getAddress();
            System.out.println(address+" : "+address2);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", embassy.getID());
            jsonObject.put("type", embassy.getType());
            jsonObject.put("telephone", embassy.getTelephone());
            jsonObject.put("address", address);
            jsonObject.put("url", embassy.getUrl());
            jsonObject.put("destination", embassy.getDestination());
            jsonObject.put("status", embassy.getStatus());
            jsonObject.put("updatedOn", embassy.getUpdatedOn());
            jsonObject.put("countryCode", embassy.getCountryCode());
            System.out.println(jsonObject.toString());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}