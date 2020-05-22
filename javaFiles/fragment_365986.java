String query = "update ptest set result = ? where patient_id = ?";
PreparedStatement preparedStatement = con.prepareStatement(query);

preparedStatement.setString(1, report);
preparedStatement.setString(2, idd);

preparedStatement.executeUpdate();