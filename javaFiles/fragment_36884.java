String insertStatement = "INSERT INTO person(\n" +
                "            name, address, phone, customer_type, \n" +
                "            start_dtm)\n" +
                "    VALUES (?, ?, ?, ?, \n" +
                "            ?)\n" +
                "    RETURNING person_id;";


PreparedStatement stmt = connection.prepareStatement(insertStatement);

stmt.setObject(1, perToSave.getName(null));
stmt.setObject(2, editToSave.getAddress());
stmt.setObject(3, editToSave.getPhone());
stmt.setObject(4, editToSave.getCustType());
long epochTime = java.lang.System.currentTimeMillis();
stmt.setObject(5, new java.sql.Date(epochTime));

stmt.executeUpdate();
ResultSet last_updated_person = stmt.getResultSet();
last_updated_person.next();
int last_updated_person_id = last_updated_person.getInt(1);