filterTextField.textProperty().addListener((obs, oldText, newText) -> {
    if (newText.isEmpty()) {
        // no filtering:
        filteredStudents.setPredicate(student -> true);
    } else {
        filteredStudents.setPredicate(student -> 
            // whatever logic you need:
            student.getFirstName().contains(newText) || student.getLastName().contains(newText));
    }
});