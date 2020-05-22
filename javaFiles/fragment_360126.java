TextField textField = ...
FilteredList<User> filteredList = ...

textField.textProperty().addListener((observable, oldValue, newValue) -> filteredList.setPredicate(newValue.isEmpty()
                      ? null
                      : user -> user.getName().contains(newValue)
                                || user.getUsername().contains(newValue)
                                || user.getPosition().contains(newValue)));