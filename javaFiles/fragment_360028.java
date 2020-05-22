String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "uuid CHAR(36) NOT NULL," +
                " team_name VARCHAR( + " + MAX + ") NOT NULL," +
                " BOOLEAN manager NOT NULL," +
                " BOOLEAN team_chat NOT NULL," +
                " PRIMARY KEY (uuid))";