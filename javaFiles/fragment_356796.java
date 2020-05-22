public static String getTopPlayer() {
    int limit = 10;

    try {
            preparedstatement st = con 
                    .preparestatement("select * from FF order by points desc limit "
                                    + limit);
            resultset rs = st.executequery();
            if (rs.next()) {
                    name = rs.getString("playername");
                    //if rs.next() rs.getString("playername"); <-- returns second
                    //if rs.next(); rs.getString("playername"); <-- returns third
            } else {
                    name = null;
            }   
    } catch (sqlexception e) {
            e.printstacktrace();
    }
    return name;