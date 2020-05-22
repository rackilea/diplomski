String Query = "select * from recommendation.sports WHERE feed LIKE CONCAT('%', ?, '%') " +
                "UNION " +
                "select * from recommendation.software  WHERE feed LIKE CONCAT('%', ?, '%') " +
                "UNION " +
                "select * from recommendation.website   WHERE feed LIKE CONCAT('%', ?, '%') " +
                "UNION " +
                "select * from recommendation.others    WHERE feed LIKE CONCAT('%', ?, '%')  " +
                "UNION " +
                "select * from recommendation.business  WHERE feed LIKE CONCAT('%', ?, '%')" ;

PreparedStatement pstmt = con.prepareStatement(Query);
pstmt.setString(1, s1);
pstmt.setString(2, s1);
pstmt.setString(3, s1);
pstmt.setString(4, s1);
pstmt.setString(5, s1);
ResultSet _result = pstmt.executeQuery();