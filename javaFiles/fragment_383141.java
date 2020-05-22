Connection con = null;
Statement st = null;
ResultSet rs = null;
try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/asteriskcdrdb", "root", "techsoft");
    st = con.createStatement();
    rs = st.executeQuery("Select * from asteriskcdrdb.sp1");
    while (rs.next()) {
        AreaCode = rs.getString("AreaCode");
        String Pulse = rs.getString("Pulse");
        Rate = rs.getInt("Rate/pulse");
        if (AreaCode.equals(str)) {
            Statement stmt = null;
            ResultSet rst = null;
            PreparedStatement insSt = null;
            try {
                //using the first connection
                stmt = con.createStatement();
                rst = stmt.executeQuery("Select * from cdr where src ='9035020090'");
                while (rst.next()) {
                    calldate = rst.getString("calldate");
                    clid = rst.getString("clid");
                    src = rst.getString("src");
                    dst = rst.getString("dst");
                    dcontext = rst.getString("dcontext");
                    channel = rst.getString("channel");
                    dstchannel = rst.getString("dstchannel");
                    lastapp = rst.getString("lastapp");
                    lastdata = rst.getString("lastdata");
                    duration = rst.getString("duration");
                    dur = Integer.parseInt(duration);
                    data.add(dur);
                    billsec = rst.getString("billsec");
                    disposition = rst.getString("disposition");
                    amaflags = rst.getString("amaflags");
                    accountcode = rst.getString("accountcode");
                    uniqueid = rst.getString("uniqueid");
                    userfield = rst.getString("userfield");
                    int newcost = checktime(dur, Rate);
                    //every ? is a parameter in the query
                    insSt = con.prepareStatement(
                        "insert into cdrcost (calldate,clid,src,dst,dcontext,channel, dstchannel, lastapp, lastdata,duration,billsec, disposition,amaflags,accountcode,uniqueid, userfield,cdrcost) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    //setting every parameter
                    insSt.setObject(1, calldate);
                    insSt.setObject(2, clid);
                    insSt.setObject(3, src);
                    insSt.setObject(4, dst);
                    insSt.setObject(5, dcontext);
                    insSt.setObject(6, channel);
                    insSt.setObject(7, dstchannel);
                    insSt.setObject(8, lastapp);
                    insSt.setObject(9, lastdata);
                    insSt.setObject(10, duration);
                    insSt.setObject(11, billsec);
                    insSt.setObject(12, disposition);
                    insSt.setObject(13, amaflags);
                    insSt.setObject(14, accountcode);
                    insSt.setObject(15, uniqueid);
                    insSt.setObject(16, userfield);
                    insSt.setObject(17, newcost);
                    //executing the insert statement
                    insSt.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                //closing the resources in this transaction
                try {
                    //the insSt statement doesn't have a resultset
                    if (insSt != null) {
                        insSt.close();
                    }
                    //the rst ResultSet is bounded to stmt Statement, it must be closed first
                    if (rst != null) {
                        rst.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException sqle) {}
            }
        } else if (AreaCode.equals(str2)) {
            System.out.println("Hii2");
        }
    }
} catch (Exception e) {
    System.out.println(e);
} finally {
    //closing the resources in this transaction
    //similar logic than the used in the last close block code
    try {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        //at the last of all the operations, close the connection
        if (con != null) {
            con.close();
        }
    } catch (SQLException sqle) {}
}