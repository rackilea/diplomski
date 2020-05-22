jdbcTemplate.execute(
            "update TABLE set BLOB = ? where PK = ?",
            new AbstractLobCreatingPreparedStatementCallback( lobHandler ) {

                @Override
                protected void setValues( PreparedStatement ps, LobCreator lobCreator ) throws SQLException {
                    lobCreator.setBlobAsBinaryStream( ps, 1, stream, sizeInBytes );
                    ps.setLong( 2, pk );
                }
            }
        );