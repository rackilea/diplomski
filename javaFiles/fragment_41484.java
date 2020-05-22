query = "SELECT * FROM clients" +
                " WHERE LOWER(" + COLUMN_BILLONE + ") NOT LIKE LOWER('bill') OR" +
                " LOWER(" + COLUMN_BILLTWO + ") NOT LIKE LOWER('bill') OR" +
                " LOWER(" + COLUMN_BILLTHREE + ") NOT LIKE LOWER('bill') OR" +
                " LOWER(" + COLUMN_BILLFOUR + ") NOT LIKE LOWER('bill') AND" +
                " (LOWER(" + COLUMN_NAME + ") LIKE LOWER('%" + inputText + "%') OR" +
                " LOWER(" + COLUMN_ADDRESS + ") LIKE LOWER('%" + inputText + "%'));"