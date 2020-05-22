public class Student {
    private String name;
    private Integer age;
    //etc.

    public Student() {
        //default constructor
    }

    public Student(final ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i < columnCount + 1; i++ ) {
          String name = rsmd.getColumnName(i);

          if (Student.getField(name)) {
              Student.getField(name).set(rs.getString(name));               
          }
        }       
    }
}