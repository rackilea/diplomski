Path databaseLocation = Paths.get("expenses.db");

if (Files.exists(databaseLocation)) {
    try {
        conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
                "There is a problem connecting database:\n"
                + e + "\n\n"
                + "Check does database \"Expenses.db\" exist",
                "Connecting error",
                JOptionPane.WARNING_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(null,
        "Database file \"" + databaseLocation + "\" does not exist.",
        "Connecting error",
        JOptionPane.WARNING_MESSAGE);
}