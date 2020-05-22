private void setup(Connection conn) throws SQLException {
    doUpdateDatabase(conn, "BEGIN " + "DBMS_AQADM.CREATE_QUEUE_TABLE( "
            + "   QUEUE_TABLE        =>  'OBJ_SINGLE_QUEUE_TABLE',  " + "   QUEUE_PAYLOAD_TYPE =>  'AQ_EVENT_OBJ', "
            + "   COMPATIBLE         =>  '10.0'); " + "END; ");
    doUpdateDatabase(conn, "BEGIN " + "DBMS_AQADM.CREATE_QUEUE( " + "    QUEUE_NAME     =>   'OBJ_SINGLE_QUEUE', "
            + "    QUEUE_TABLE    =>   'OBJ_SINGLE_QUEUE_TABLE'); " + "END;  ");
    doUpdateDatabase(conn, "BEGIN " + "  DBMS_AQADM.START_QUEUE('OBJ_SINGLE_QUEUE'); " + "END; ");
}