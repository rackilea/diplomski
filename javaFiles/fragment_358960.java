private void checkDBVersion () {
        ProgressForm pForm = new ProgressForm();
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                SimpleStringProperty version = new SimpleStringProperty();
                Connection targetDBconn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {
                    targetDBconn = globalTargetConn.connect();
                    Platform.runLater(new Runnable(){@Override public void run() {logWriter.writeLogs(logTextArea, LogWriter.INFO, "Checking this database version...");}});
                    pstmt = new LoggableStatement(targetDBconn, SqlList.checkTargetDBVersionSQL);
                    String SQL = ((LoggableStatement) pstmt).getQueryString();
                    Platform.runLater(new Runnable(){@Override public void run() {logWriter.writeLogs(logTextArea, LogWriter.INFO, "See the query below...");}});
                    Platform.runLater(new Runnable(){@Override public void run() {logWriter.writeLogs(logTextArea, LogWriter.INFO, SQL);}});
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        version.set(rs.getString(1));
                        targetDatabaseInfo.setVersion(version);
                    }
                    Platform.runLater(new Runnable(){@Override public void run() {logWriter.writeLogs(logTextArea, LogWriter.INFO, "Your database version is " + version.getValue());}});
                } catch (SQLException ex) {Platform.runLater(new Runnable(){@Override public void run() {logWriter.writeLogs(logTextArea, LogWriter.ERROR, ex.getMessage());}}); 
                } finally {
                    if (rs != null ) try {rs.close();} catch(SQLException ex) {}
                    if (pstmt != null ) try {pstmt.close();} catch(SQLException ex) {}
                    if (targetDBconn != null ) try {targetDBconn.close();} catch(SQLException ex) {}
                }
                _DB_VERSION = version;
                updateProgress(-1, -1);
                return null;
            }
        };
        pForm.activateProgressBar(task);
        task.setOnSucceeded(event -> {
            pForm.getDialogStage().close();
        });
        pForm.getDialogStage().show();
        Thread thread = new Thread(task);
        thread.start();
    }