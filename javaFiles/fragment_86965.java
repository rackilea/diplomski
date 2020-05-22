public void run(){
    LOGGER.log(Level.INFO, "Thread Created: " +Thread.currentThread().getName());
    try {
            JSONObject msg = content.take();
            // JSON
            for(String tableName : tableList){
                CassandraConnector.getSession().execute(createQuery(tableName, msg));
            }
     } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
     }
}