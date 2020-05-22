CallableStatement st = con.prepareCall("BEGIN ? := ADD_ADDRESS_FUNC( Address_Type(?,?,?,?)); END;");

st.registerOutParameter( 1, Types.INTEGER );
st.setString( 2, "Address 1" );
st.setString( 3, "Address 2" );
st.setString( 4, "Town" );
st.setString( 5, "County" );

st.execute();
int id = st.getInt(1);