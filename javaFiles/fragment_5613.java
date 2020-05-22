class StatementHelper{
    static void setDouble(int index, PreparedStatement preparedStatement, Double val) throws SQLException {
        if (val == null )
            preparedStatement.setNull(index, java.sql.Types.NULL);
        else
            preparedStatement.setDouble(index, val);
    }

    //Repeat for other data types
}