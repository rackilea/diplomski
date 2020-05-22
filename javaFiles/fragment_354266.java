query = "UPDATE bookings SET date = ? WHERE id = ?";

preparedStatement = con.prepareStatement(query);
preparedStatement.setDate(1, da);
preparedStatement.setInt(2, id);
preparedStatement.executeUpdate();