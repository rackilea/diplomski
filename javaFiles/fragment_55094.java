try (PreparedStatement checkAccountExists = con.prepareStatement(
        "SELECT BALANCE FROM SAVINGS WHERE ACCOUNTNUMBER = ?")) {
     checkAccountExists.setInt(1, acc);

     try (ResultSet RS = checkAccountExists.executeQuery()) {
          if (RS.next()) {
              int currentbal = RS.getInt("BALANCE");
              int newbalance = currentbal + Amount;

              try (PreparedStatement stmt = con.prepareStatement(
                    "UPDATE SAVINGS SET BALANCE = ? WHERE ACCOUNTNUMBER = ?")){ 

                   stmt.setInt(1, newbalance);
                   stmt.setInt(2, acc);

                   stmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "you have made a deposit to "+acc);
              }

          } else {
              JOptionPane.showMessageDialog(null, "Invalid Account Number");
          }
     }
}