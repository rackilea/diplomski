try (CallableStatement cs 
        = myConnection.prepareCall("{ call DBMS_STREAMS_ADM.SET_TAG(HEXTORAW(?)) }")) {

    cs.setString(1, "17");        
    cs.execute();
}