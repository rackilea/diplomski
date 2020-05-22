public int checkUsername(String sUsername) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count =0;
        try{
            conn = DatabaseManager.con();
            String query="select count(*) from Staff where username=? ";
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,sUsername);
            rs=pstmt.executeQuery();

            while (rs.next()) {
                count=rs.getInt("count(*)");

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (rs != null)
                DatabaseManager.rs_close(rs);
            if (pstmt != null)
                DatabaseManager.stmt_close(pstmt);
            if (conn != null)
                DatabaseManager.con_close(conn);
        }
        return count;

    }