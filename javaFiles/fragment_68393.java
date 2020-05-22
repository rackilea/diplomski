if (myInt != null) {
    pstmt.setInt(1, myInt);
} else {
    pstmt.setNull(1, Types.INTEGER);
}
pstmt.setDate(2, myDate);  // already handles null
// and so on