String query2 = "INSERT INTO APP.Shortlist(ClientID, WorkerID)\n" +
                    "SELECT ClientID, WorkerID\n" +
                    "FROM APP.CLIENT_TABLE, APP.WORKER_TABLE\n" +
                    "WHERE APP.CLIENT_TABLE.WORKER_NEEDED = APP.WORKER_TABLE.JOB_1 OR\n" + 
                    "APP.CLIENT_TABLE.WORKER_NEEDED = APP.WORKER_TABLE.JOB_2 OR\n" +
                    "APP.CLIENT_TABLE.WORKER_NEEDED = APP.WORKER_TABLE.JOB_3 AND\n" +
                    "APP.CLIENT_TABLE.CLIENTID =  ?";

PreparedStatement prepStat = con.prepareStatement(query2);
prepStat.setString(1, jTextField1);
prepStat.executeUpdate();