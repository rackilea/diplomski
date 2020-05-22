conn = DriverManager.getConnection("jdbc:sqlite:***");
// Set auto-commit to false which enable the transactional mode
conn.setAutoCommit(false);
...
// Explicitly commit statements to apply changes
conn.commit();