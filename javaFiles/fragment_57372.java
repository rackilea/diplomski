protected void getAgentIdNo (Connection con, PreparedStatement preStatement,
                ResultSet result, String initials, Date myDate) {
        try {
            preStatement = con.prepareStatement("SELECT * FROM AGENTDETAIL as ag WHERE ag.initial = ? AND date = ?");
            preStatment.setSring(1,initials);
            preStatment.setString(2,date);
            result = preStatement.executeQuery();

        while (result.next()) {
                    System.out.println("The date and initials matched !!");
                    System.out.println("The id no is " + result.getint("idNo");
            }
        }
    }

    catch (SQLException ex) {
        System.out.println("An error occured when reading from the data base");
        ex.printStackTrace();
    }
}