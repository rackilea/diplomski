public ArrayList getStudentFirstName(){
        ArrayList<Name> v = new ArrayList<Name>();
        Connection conn;
        try{
         conn =  db.getDbConnection();
         String sql = "select STU_FIRST_NAME, STU_MIDDLE_NAME from college_students_master";
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         Name name = null;
         while(rs.next()){
             name = new Name();
             name.setFirstName(rs.getString("STU_FIRST_NAME")); //set your firstName
             name.setMiddleName(rs.getString("STU_MIDDLE_NAME")); //set your MiddleName
             name.setLastName(rs.getString("LAST_NAME")); //set your LastName
             v.add(name); 
         }
        }catch(Exception asd){
            System.out.println(asd.getMessage());
        }
        return v;
    }