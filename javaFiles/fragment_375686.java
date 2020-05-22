DAO myDAO = ... ;

Task<List> task = new Task<List>() {
    @Override
    public void call() throws Exception {
        return myDAO.getSelectList(...);
    }
});

task.setOnSucceeded(event -> {
    List list = task.getValue();
    // use list to update UI...
});

task.setOnFailed(event -> {
    Exception exc = task.getException();
    // handle exception...
});

Thread thread = new Thread(task);
thread.setDaemon(true);
thread.start();