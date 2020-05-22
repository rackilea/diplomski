return jdbcTemplate.queryForObject( 
        "select BLOB from TABLE where PK = ?",
        args,
        new RowMapper<InputStream>() {

            @Override
            public InputStream mapRow( ResultSet rs, int rowNum ) throws SQLException {
                return lobHandler.getBlobAsBinaryStream( rs, 1 );
            }
        }
    );