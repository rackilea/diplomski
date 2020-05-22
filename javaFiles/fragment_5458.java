public class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Display/center the JDialog when the button is pressed
        final String table = "teacherexample"; // Personal opinion: if something
                                               // wont change, define it final
        int num = 500; //Your number here, i guess from scanner input.
        String sql = ("DELETE FROM " + table + " ") + "WHERE EntryNumber = " + num;
        // Since java 8, auto closable, read https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (Connection myConn = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/interndata?useSSL=false",
                    "root", "Starwars991211");PreparedStatement preparedStatement = myConn.prepareStatement(sql);) 
        {
            preparedStatement.executeUpdate(sql);
        }
        catch (SQLException exc) { // Catching all exceptions is bad practice
                                   // catch only the exception you wait here...
            exc.printStackTrace();
        }
    }
}