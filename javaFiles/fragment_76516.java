UsersListTask.setOnSucceeded(event ->
    UsersList.setItems(
        FXCollections.observableArrayList(UsersListTask.getValue())
    )
);

UsersListTask.setOnFailed(event ->
    System.out.println("ERROR: " + UsersListTask.getException())
);