final Task<List<User>> UsersListTask = new Task<List<User>>() {
    protected List<User> call() throws SQLException {
        return new DatabaseManager().returnUsers();
    }
};

UsersListTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    @Override public void handle(WorkerStateEvent event) {
        UsersList.setItems(
            FXCollections.observableArrayList(UsersListTask.getValue())
        );
    }
});

UsersListTask.setOnFailed(new EventHandler<WorkerStateEvent>() {
    @Override public void handle(WorkerStateEvent event) {
        System.out.println("ERROR: " + UsersListTask.getException());
    }
});

new Thread(UsersListTask).start();