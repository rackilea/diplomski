} catch (SQLException e) {
    e.printStackTrace();

    JOptionPane.showMessageDialog(null,
            "There is a problem connecting database:\n"
            + e + "\n\n"
            + "Check does database \"Expenses.db\" exist",
            "Connecting error",
            JOptionPane.ERROR_MESSAGE);
}