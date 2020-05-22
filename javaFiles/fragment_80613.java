session = cluster.connect();
    ResultSet results = getSession()
        .execute("SELECT key,broadcast_address,cql_version FROM system.local");

    for (Row row : results) {
        System.out.println(row.getString("key") + " "
            + row.getInet("broadcast_address") + " "
            + row.getString("cql_version"));
    }

local 127.0.0.1 3.4.4