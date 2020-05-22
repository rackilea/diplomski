} finally {
    // ...
    if (conn != null) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}