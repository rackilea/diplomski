@WebService(name = "Reservation", serviceName = "ReservationService")
public class ReservationSOAP {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:8080/Reservation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // a WebMethod that can reserve a seat
    @WebMethod(operationName = "reserve")
    public boolean reserve(@WebParam(name = "seatType") String seatType,
            @WebParam(name = "classType") String classType) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                PreparedStatement lookupSeat = connection
                        .prepareStatement("SELECT ID FROM seats WHERE taken = ? AND location = ? AND class = ?")) {
            System.out.println("seatType: " + seatType);
            System.out.println("classType: " + classType);
            lookupSeat.setInt(1, 0);
            lookupSeat.setString(2, seatType);
            lookupSeat.setString(3, classType);

            try (ResultSet resultSet = lookupSeat.executeQuery()) {

                // if requested seat is available, reserve it
                if (resultSet.next()) {
                    int seat = resultSet.getInt(1);
                    System.out.println(
                            "Found unreserved seat: " + seat + " in class " + classType + " and seatType " + seatType);
                    try (PreparedStatement reserveSeat = connection
                            .prepareStatement("UPDATE seats SET taken = 1 WHERE ID = ?")) {
                        reserveSeat.setInt(1, seat);
                        reserveSeat.executeUpdate();
                        return true;
                    }

                }
            }
            System.out.println("No Seat found.");
            return false;
        } // end try
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } // end WebMethod reserve
} // end class Reservation