@Override
public void actionPerformed(ActionEvent arg0) {
    if (garageView.getTxtNewPassword().getText().isEmpty() == false
            && garageView.getTxtNewUsername().getText().isEmpty() == false) {
        username = garageView.getTxtNewUsername().getText();
        password = garageView.getTxtNewPassword().getText();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GarageDoctor.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully - SELECT");

            stmt = c.createStatement();
            String selectSql = "SELECT NAME FROM USERS WHERE NAME = '" + username + "';";
            ResultSet rs = stmt.executeQuery(selectSql);
            boolean exists = rs.next();
            System.out.println("closing");
            rs.close();
            stmt.close();
            c.close();
            System.out.println("closed");
            if (exists) {
                JOptionPane.showMessageDialog(garageView, "User Already Exists!");
                selectUser = "";
            } else {
                System.out.println("user isn't in db, inserting now");
                DBInsertNewUsers(username, password);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    } else {
        JOptionPane.showMessageDialog(garageView, "Invalid input");
    }
}