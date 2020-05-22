String namecount = "SELECT count(*) FROM People WHERE LOWER(NAME) LIKE :pname ";
String finalName= "%" + nameParam.toLowerCase().trim() + "%";

MapSqlParameterSource namedParams= new MapSqlParameterSource();
namedParams.addValue("pname", finalName);

int count= this.namedParamJdbcTemplate.queryForInt(namecount, namedParams);