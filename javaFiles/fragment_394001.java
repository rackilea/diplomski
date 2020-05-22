hiveJdbcTemplate.query(sqlToExecute, rs -> {
            rs.setFetchSize(5000);
            while (rs.next()){
               ....do you handling
            }
        });