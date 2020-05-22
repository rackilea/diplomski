String sql = "Update tbl_codes set No= ?,ITEM_CODE=?,DISCRIPTION=?,PREVIOUS_BIN_BALANCE=?
                    ,DATE=?,ISSUED_QUANTATY=?,ISSUED_INVOICE_NO=?,ARRIVED_QUANTATY=?,ARRIVED_INVOICE_NO=?,FINAL_BINCARD_BALANCE=? WHERE No=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, value1);
pstmt.setString(2, value2);
pstmt.setString(3, value3);
pstmt.setString(4, value4);
pstmt.setString(5, value5);
pstmt.setString(6, value6);
pstmt.setString(7, value7);
pstmt.setString(8, value8);
pstmt.setString(9, value9);
pstmt.setString(10, value10);
pstmt.setString(11, value1);
pstmt.executeUpdate();