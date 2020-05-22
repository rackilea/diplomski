public class MensajeService {

    public MensajeService() {
    }

    public void saveFile(int id, byte[] fileData) throws SQLException {
        //this is a very simple skeleton, you have to adapt this to 
        //your needs, the way you're connecting to dabatase, etc...
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ... //get the connection to your postgre db

            //Initialize a new transaction
            con.setAutoCommit(false);
            // Get the Large Object Manager to perform operations with
            LargeObjectManager lobj = ((org.postgresql.PGConnection)conn)
                .getLargeObjectAPI();
            // Create a new large object
            int oid = lobj.create(LargeObjectManager.READ | LargeObjectManager.WRITE);
            // Open the large object for writing
            LargeObject obj = lobj.open(oid, LargeObjectManager.WRITE);
            //in the provided example, the code shows a way to get the byte array data
            //from the file (using the File and FileInputStream classes)
            //you don't need all that because you already have the byte array (good!)
            //so you only write the binary data in your LargeObject (OID) object
            obj.write(fileData);

            //creating the SQL statement to insert the OID
            String sql = "INSERT INTO mensaje VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ps.setInt(2, oid);
            //
            pstmt.setBinaryStream(2, fin, (int) img.length());
            //saving the file
            pstmt.executeUpdate();
            //closing the transaction successfully
            con.commit();
        } catch (SQLException e) {
            //error in the transaction, start a rollback
            if (con != null) {
                con.rollback();
            }
            throw e;
        } finally {
            //don't forget to free the resources after using them
            pstmt.close();
            con.close();
        }
    }
}