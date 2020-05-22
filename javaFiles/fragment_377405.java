public class MyDAO {

    private Connection conn ; 

    // constructor etc...

    public Course getCourseByCode(int code) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("select * from course where c_code = ?")) {
            pstmt.setInt(1, code);
            ResultSet results = pstmt.executeQuery();
            if (results.next()) {
                Course course = new Course();
                course.setName(results.getString("c_name"));
                // etc...
                return course ;
            } else {
                // maybe throw an exception if you want to insist course with given code exists
                // or consider using Optional<Course>...
                return null ;
            }
        }
    }

    // ...
}