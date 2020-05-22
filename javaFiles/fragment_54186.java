TEnclosure factory = new TEnclosure();

    Connection connection = null;
    OracleConnection oracleConnection = null;
    OracleCallableStatement oracleCallableStatement = null;

    try {
        connection = MyConnectionFactory.getConnection(SOME_CONNECTION_CONFIG);
        oracleConnection = connection.unwrap(OracleConnection.class);
        oracleCallableStatement = (OracleCallableStatement) oracleConnection.prepareCall("{? = call zoo_schema.zoo_utils.GET_ENCLOSURE( ? )}");

        oracleCallableStatement.registerOutParameter(1, OracleTypes.STRUCT, "zoo_schema.T_ENCLOSURE");
        oracleCallableStatement.setInt(2, 6);  // fetch data for ENCLOSURE#6

        // Execute query
        oracleCallableStatement.executeQuery();

        // Check result
        Object oraData = oracleCallableStatement.getORAData(1, factory);
        LOGGER.info("oraData is a {}", oraData.getClass().getName()); // acme.zoo.TEnclosure

    } finally {
        ResourceUtils.closeQuietly(oracleCallableStatement);
        ResourceUtils.closeQuietly(oracleConnection);
        ResourceUtils.closeQuietly(connection); // probably not necessary...
    }