... main(...) {
    JSql1 app = new JSql1();
    try {
        app.openConnection();
        app.createDB();
        app.createTables():
    } catch (SQLException e) {
        Logger.getLogger(JSql1.class.getName()).log(Level.FATAL, "...", e);
    } finally {
        app.close();
    }