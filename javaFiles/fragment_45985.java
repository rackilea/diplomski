SimpleJdbcCall countryProcedure = new SimpleJdbcCall(dataSource)
        .withoutProcedureColumnMetaDataAccess()
        .withProcedureName(procedureName)
        .declareParameters(new SqlOutParameter("RETURNCODE", Types.INTEGER))
        .declareParameters(new SqlOutParameter("RETURNMSG", Types.VARCHAR));
Map result = countryProcedure.execute();
        System.out.println("RETURNCODE: " + result.get("RETURNCODE"));
        System.out.println("RETURNMSG: " + result.get("RETURNMSG"));