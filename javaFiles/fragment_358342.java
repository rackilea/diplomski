PreparedStatement ps = stmt.prepareStatement( "SELECT COUNT(*) as total FROM reservation WHERE idRoom = ? AND (? >= arrivaldate AND ? <= departuredate) OR (? >= arrivaldate AND ? <= departuredate)");

int c = 0;
ps.setInt(++c, idRoom);
ps.setDate(++c, arrivaldate);
ps.setDate(++c, departuredate);
ps.setDate(++c, arrivaldate);
ps.setDate(++c, departuredate);

ResultSet rs = ps.executeQuery();
// And your usual code here