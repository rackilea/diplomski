PreparedStatement updateStatement = connection.prepareStatement("INSERT INTO STUDENTS VALUES ('S1', 2)");
        try {
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            updateStatement.close();
        }