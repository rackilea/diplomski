public void testString(Connection connection) {
  String[] values = { "alpha", "beta", "gamma" };
  try {
    OracleConnection oc = (OracleConnection) connection;

    ARRAY stringArray = oc.createARRAY( "STRINGARRAY", values ); // Upper case identifier

    OracleCallableStatement st = (OracleCallableStatement) oc.prepareCall(
      "begin test.upper( :in_array, :out_array ); end;"
    );

    st.setARRAYAtName( "in_array", stringArray );
    st.registerOutParameter( "out_array", Types.ARRAY, "STRINGARRAY"); // Upper case again
    st.execute();

    String[] result = (String[])st.getARRAY( 2 ).getArray();

    System.out.println("Length: " + result.length);
    System.out.println("First: " + result[0]);
  } (catch SQLException e) {
    // Handle error
  }
}