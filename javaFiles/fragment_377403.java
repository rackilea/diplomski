public class WidgetDAO {

    // In real life, you might want a connection pool here, though for
    // desktop applications a single connection often suffices:
    private Connection conn ;

    public WidgetDAO() throws Exception {
        conn = ... ; // initialize connection (or connection pool...)
    }

    public List<Widget> getWidgetsByType(String type) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("select * from widget where type = ?")) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            List<Widget> widgets = new ArrayList<>();
            while (rs.next()) {
                Widget widget = new Widget();
                widget.setName(rs.getString("name"));
                widget.setNumberOfBigRedButtons(rs.getString("btnCount"));
                // ...
                widgets.add(widget);
            }
            return widgets ;
        }
    }

    // ...

    public void shutdown() throws Exception {
        conn.close();
    }
}