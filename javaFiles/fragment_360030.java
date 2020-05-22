String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "uuid CHAR(36) NOT NULL," +
                " team_name VARCHAR(255) NOT NULL," +
                " manager BOOLEAN NOT NULL," +
                " team_chat BOOLEAN NOT NULL," +
                " PRIMARY KEY (uuid))";

    String query2 = "CREATE TABLE IF NOT EXISTS " + secondTableName + " (" +
            "team_name VARCHAR(255) NOT NULL," +
            " team_password VARCHAR(255) NOT NULL" +
            " friendly_fire BOOLEAN  NOT NULL," +
            " hq VARCHAR(255)," +
            " rally VARCHAR(255)," +
            " PRIMARY KEY (team_name))";