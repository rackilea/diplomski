public static boolean doesNumberExist(int numberToFind) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Integer> nums = new ArrayList<>();
        String sql = "SELECT number from DB";

        try(Connection conn = DriverManager.getConnection("");){

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                int num = rs.getInt ("number");
                // ADD NUMBER TO THE LIST
                nums.add(num);
            }   
        }
        finally{
            ps.close();
            rs.close();
        }
        // RETURN IF LIST CONTAINS NUMBER OR NOT
        return nums.contains(numberToFind);
    }