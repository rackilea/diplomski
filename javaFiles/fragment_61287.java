anyClassMethod() {
    if (con != null) {
        SmartClientKernel.addPooledTask(new MyRunnable(con, tableName, userName, sessionId, projectName));
    }
}

private class MyRunnable implements Runnable {

    Connection con;
    String tableName, userName, sessionId, projectName;

    MyRunnable(Connection con, String tableName, String userName, String sessionId, String projectName) {
        this.con = con;
        this.tableName = tableName;
        this.userName = userName;
        this.sessionId = sessionId;
        this.projectName = projectName;
    }

    @Override
    public void run() {
        ActionDispatcher.getInstance().addDispatchExtension(new MyIDispatchExtension(con, tableName, userName, sessionId, projectName));
    }
}

private class MyIDispatchExtension (extends or implements) IDispatchExtension {

    Connection con;
    String tableName, userName, sessionId, projectName;

    public MyIDispatchExtension(Connection con, String tableName, String userName, String sessionId, String projectName) {
        this.con = con;
        this.tableName = tableName;
        this.userName = userName;
        this.sessionId = sessionId;
        this.projectName = projectName;
    }

    @Override
    public void preprocessActionExecution(RPAction action) {
        Calendar cal = Calendar.getInstance();
        Date startTime = cal.getTime();
        String actionName = action.getName();
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(startTime.getTime());
        UUID id = UUID.randomUUID();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement("INSERT INTO " + tableName
                    + " (ID, USERNAME, SESSIONID, PROJECTNAME, STARTTIME, ACTIONTYPE, ACTIONNAME) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, id.toString());
            statement.setString(2, userName);
            statement.setString(3, sessionId);
            statement.setString(4, projectName);
            statement.setTimestamp(5, sqlTime);
            statement.setString(6, "Action");
            statement.setString(7, actionName);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            Log.getLogger().log(Level.SEVERE, e.getMessage(), e);
        }

    }
}