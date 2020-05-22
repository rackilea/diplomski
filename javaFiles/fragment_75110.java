public void createTable(){
        try{
            log.info("creating Table.");
            pstmt = conn.prepareStatement(createString);
            pstmt.execute();
            pstmt.close();
        }catch(SQLException e){
            if(e.getSQLState().equals("X0Y32")){
                log.info("table " + tableName + " is already exist.");
            }
        }
    }