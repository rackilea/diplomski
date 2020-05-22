create or replace function get_refcursor
return sys_refcursor
is
 c sys_refcursor;
begin
  open c for select 1 x from dual;
  return c;
end;


    DriverManager.registerDriver ( new oracle.jdbc.driver.OracleDriver());
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@****:1521:***","***","***");

    OracleCallableStatement cstmt = (OracleCallableStatement)conn.prepareCall("{ ? = call get_refcursor }"); ;
    cstmt.registerOutParameter(1, OracleTypes.CURSOR);
    cstmt.execute();
    ResultSet rs = (ResultSet)cstmt.getObject(1);
    while(rs.next()) {
        System.out.println('Result: '+rs.getBigDecimal(1));
    }
    rs.close();
    cstmt.close();

Result: 1