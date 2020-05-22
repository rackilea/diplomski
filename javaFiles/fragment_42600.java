OracleConnection conn;  // initialize this first

CLOB clob = conn.createClob();

public Clob getClob(String data){

    return clob.setString(position, data);
}