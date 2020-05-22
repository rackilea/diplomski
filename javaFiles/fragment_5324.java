class UpdateTask implements Callable<Exception> {
  //constructor with jdbctemplate,sql,param goes here.
  @Override
    public Exception call() throws Exception {
        try{
              jdbcTemplate.update(sql, Object[] param)
            }catch(Exception ex){
                   return ex;
           }

        return null;
    }