String sql3 = "INSERT INTO TRANSACTION " + 
                        "VALUES(TransNumSeq.NEXTVAL, ?, ?, ?, ?, ?)";
pstmt3 = conn.prepareStatement(sql3);
pstmt3.setInt(1, id);
pstmt3.setInt(2, payment);
pstmt3.setString(3, payment_desc);
pstmt3.setInt(4, creditCard);
pstmt3.setInt(5, change);