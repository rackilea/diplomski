public static void main(String[] args) throws SQLException, Exception {
    Connection con = ConnectionDefinition.getOracleConnection(); //my oracle connection
    CallableStatement cs = con.prepareCall("declare \n"
            + " procedure MYPROCEDURE(p1 varchar2,p2 varchar2,p3  out clob,p4 varchar2) is \n"
            + " begin \n"
            + "       dbms_lob.createtemporary(p3, true); \n"
            + "       dbms_lob.append(p3,p1||' - '||p2||' - '||p4);\n"
            + " end; \n"
            + "BEGIN\n"
            + "  MYPROCEDURE(?,?,?,?);\n"
            + "END; \n"
            + "    \n"
            + "");
    cs.setString(1, "first param");
    cs.setString(2, "secound param");
    cs.registerOutParameter(3, Types.CLOB);
    cs.setString(4, "four param");
    cs.execute();
    Clob cl = cs.getClob(3);
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();
    String line;
    try {
        br = new BufferedReader(new InputStreamReader(cl.getAsciiStream()));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
    } catch (IOException e) {
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
    }
    System.err.println(sb.toString());
}