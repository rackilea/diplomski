// Object array containing the values corresponding to your row type
Object[] rowObj = { "X" };
// Struct based on the SQL type you created
StructDescriptor structDesc = StructDescriptor.createDescriptor("NI_IMSI_ROWTYPE", conn);
STRUCT rowStruct = new STRUCT(structDesc, conn, rowObj);

// Call wrapper function instead of real one
cs = conn.prepareCall("{ call ni_imsi_pkg.get_curx_wrapper(?,?) }");
// Pass the struct defined earlier
cs.setObject(1, rowStruct);
cs.registerOutParameter(2, OracleTypes.CURSOR);
// and other arguments for your real calll