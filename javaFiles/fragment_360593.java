public void addCourseToCourses(final String values) {
    handleSql(new SqlCommand() {
        @Override public void run(Statement stmt) {
            stmt.executeUpdate("insert into courses values " + values);
        }
    });
}