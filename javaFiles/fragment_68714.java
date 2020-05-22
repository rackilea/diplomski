public static void main(String[] args) throws SQLException, Exception {
        Connection con = ConnectionDefinition.getOracleConnection(); //my oracle connection
        PreparedStatement ps = con.prepareStatement("SELECT a.b FROM xml_test a");       
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
           if( rs.getObject(1) != null ){
                 SQLXML xml = rs.getSQLXML(1);
                 System.err.println(xml.getString());
           } else {
                 System.err.println("xmltype is null");
           }                     
        }
        rs.close();
        con.close();        
    }