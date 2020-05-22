Connection con = ....;

// turn on support for dbms_output
CallableStatement cstmt = con.prepareCall("{call dbms_output.enable(32000) }");
cstmt.execute();

// run your PL/SQL block
Statement stmt = con.createStatement();
String sql =
    "declare  \n" +
    " a number;  \n" +
    " cursor c1 is select id from foo;  \n" +
    "begin  \n" +
    "  open c1; \n" +
    "  loop \n" +
    "    fetch c1 into a;  \n" +
    "    exit when c1%notfound;  \n" +
    "    dbms_output.put_line('ID: '||to_char(a)); \n" +
    "  end loop; \n" +
    "end;";
stmt.execute(sql);

// retrieve the messages written with dbms_output
cstmt = con.prepareCall("{call dbms_output.get_line(?,?)}");
cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
cstmt.registerOutParameter(2,java.sql.Types.NUMERIC);

int status = 0;
while (status == 0)
{
    cstmt.execute();
    String line = cstmt.getString(1);
    status = cstmt.getInt(2);
    if (line != null && status == 0)
    {
        System.out.println(line);
    }
}