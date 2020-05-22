public void run(){
    Statement statement;
    try{
        MyDAO dao = new MyDAO(); // doesn't need closing
        List<Results> res = dao.findResults(...);
        statement = getStatement(); // must be closed
        ....
    } catch (Exception e){
        // handle the error
    } finally {
        if (statement!=null) statement.close();
    }
}