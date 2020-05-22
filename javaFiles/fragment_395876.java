String insertTableSQL = "SELECT T0.\"ID\" AS \"COL0\" FROM STUDENT_TABLE T0 WHERE ( ( ( T0.\"STUDENT_NAME\" =  ?  ) AND ( T0.\"GRADE\" =  ?  ) ) AND ( T0.\"STUDENT_NO\" LIKE  ?  ) )";               
             PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "A");
            preparedStatement.setString(3, "12%");
            preparedStatement.execute();