//Need to create connection
ArrayDescriptor desArray = ArrayDescriptor.createDescriptor("XPTO.TABLE_XPTO", conn);

//I don't need to send information for procedure
ARRAY array_to_pass = new ARRAY(desArray, conn, null);

...
//When you contruct the statement it is needed use the setArray
proc_strm.setArray(7, array_to_pass);