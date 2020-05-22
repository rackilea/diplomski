PreparedStatement stmt = ...;
try
{
    stmt.executeUpdate();
}
catch (SQLException e) {
    if (e.getErrorCode() == -803)
    {
        // handle duplicate entry
    }
    else
    {
        // handle other errors
    }
}