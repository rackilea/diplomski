private String query = "SELECT * FROM t WHERE NAME=?";
public void foo() {
    // connecting to DB...try-catch-block...
    ResultSet rs = null;
    try (PreparedStatement ps = c.prepareStatement(query);) {
        ps.setString(1, "Tom");
        rs = ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public void boo() {
    // connecting to DB...try-catch-block...
    // Here I want to concat the query with something
    String sql = query + " AND City=?";
    ResultSet rs = null;
    try (PreparedStatement ps = c.prepareStatement(sql);) {
        ps.setString(1, "Tom");
        ps.setString(2, "London");
        rs = ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}