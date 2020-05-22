SQLWarning warning = pstmt.getWarnings();
while (warning != null)
{
    System.out.println("Warning: " + warning.getSQLState()
        + ": " + warning.getErrorCode());
    System.out.println(warning.getMessage());
    warning = warning.getNextWarning();
}