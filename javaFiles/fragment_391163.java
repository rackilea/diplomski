try {
    count = stmt.executeUpdate(sql);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}