String custname = request.getParameter("customerName"); // This should REALLY be validated too
 // perform input validation to detect attacks
 String query = "SELECT account_balance FROM user_data WHERE user_name = ? ";

 PreparedStatement pstmt = connection.prepareStatement( query );
 pstmt.setString( 1, custname); 
 ResultSet results = pstmt.executeQuery( );