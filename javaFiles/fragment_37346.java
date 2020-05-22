RowSet rowSet = namedParameterJdbcTemplate.query(query, params, new ResultSetExtractor<RowSet>() {
            @Override
            public RowSet extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                OracleCachedRowSet rs = new OracleCachedRowSet();
                rs.populate(resultSet);

                // Have to add a empty row, because jasper is not displaying
                // the first row of report.
                rs.setReadOnly(false);
                rs.beforeFirst();
                rs.moveToInsertRow();

                int numCol = rs.getMetaData().getColumnCount();
                for (int i = 1; i < numCol + 1; i++) {
                    // Add null inserted row to each column
                    rs.updateNull(i);
                }

                rs.insertRow();
                rs.beforeFirst();
                return rs;
            }
        });