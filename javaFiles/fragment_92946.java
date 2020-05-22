package de.scrum_master.aspect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import de.scrum_master.app.DBConnection;

public aspect SqlUpdater {
    void around() : execution(public void addDetails(..)) {
        System.out.println(thisJoinPoint);
        String sqlText = createSqlStatement(thisJoinPoint.getTarget().getClass(), thisJoinPoint.getArgs());
        System.out.println("  " + sqlText);
        connectToDbAndUpdate(sqlText);
        proceed();
    }

    private static String createSqlStatement(Class<?> targetClass, Object[] args) {
        StringBuilder sqlText = new StringBuilder("INSERT INTO ");
        sqlText.append(targetClass.getSimpleName() + "s ").append("VALUES (");
        int argSize = args == null ? 0 : args.length;
        int i = 0;
        for (Object arg : args) {
            i++;
            sqlText.append(arg instanceof String ? "'" : "").append(arg);
            if (i < argSize)
                sqlText.append(arg instanceof String ? "', " : ", ");
            else
                sqlText.append(arg instanceof String ? "'" : "");
        }
        sqlText.append(")");
        return sqlText.toString();
    }

    private static void connectToDbAndUpdate(String sqlText) {
        Connection sqlConnection = null;
        DBConnection dbConnection = new DBConnection();
        try {
            sqlConnection = DBConnection.createConnection();
            Statement sqlStatement = sqlConnection.createStatement();
            sqlStatement.executeUpdate(sqlText);
            dbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}