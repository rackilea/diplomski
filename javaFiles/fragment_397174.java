public class DBConnect {
    private Connection conn;

    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unal_grades", "root", "");
        }catch(Exception ex){
             System.out.println("Error: " + ex);
        }
    }

    public ArrayList<Semester> getSemesters(){
        ResultSet rs;
        try{
            Statement st = conn.createStatement();
            ArrayList<Semester> semesters = new ArrayList<Semester>();
            String query = "Select * from semester";
            rs = st.executeQuery(query);
            System.out.println("semesters");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float average = rs.getFloat("average");
                boolean active = rs.getBoolean("active");

                System.out.println(name+" / "+average+" / "+active);
                Semester semester = new Semester(id, name, average, active);
                semester.setClasses(getClasses(semester));
                semesters.add(semester);
            }
            System.out.println();
            return semesters;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }
}