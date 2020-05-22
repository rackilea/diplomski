private String getElement(int row, int col) {
    String result = null;
    try {
        if(rs.absolute(row*colNumber+col+1))
            result=rs.getString("content");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return result;
}