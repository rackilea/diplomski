String sql = "INSERT INTO location(address1, address2, postcode, town, type)";
             + " VALUES (:address1, :address2, :postcode, :town,"
                           + " (SELECT id FROM location_type WHERE type='main'))";

Map parameters = new HashMap();
parameters.put("address1", address1);
parameters.put("address2", address2);
parameters.put("postcode", postcode);
parameters.put("town", town);

this.namedParameterJdbcTemplate.update(sql, parameters);