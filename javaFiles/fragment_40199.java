private AutoCompletionBinding<String> completion;
....
private void loadValuesToComboSearchBox() {
    try {
        // clear selection
        comboSearch.getItems().clear();
        comboSearch.valueProperty().set(null);
        comboSearch.getEditor().clear();

        comboSearch.setEditable(false);
        ResultSet getSearchElements = employeDao.getSearchemployeeByNicFnameLnmeId();
        Set<String> addElements = new LinkedHashSet<>();
        while (getSearchElements.next()) {
            addElements.add(getSearchElements.getString("id"));
            addElements.add(getSearchElements.getString("firstname"));
            addElements.add(getSearchElements.getString("lastname"));
            addElements.add(getSearchElements.getString("nic"));
        }

        if (completion != null) {
            completion.dispose();
        }
        completion = TextFields.bindAutoCompletion(comboSearch.getEditor(), addElements);
        comboSearch.setEditable(true);
    } catch (Exception e) {
        new Alert(Alert.AlertType.INFORMATION, e + "", ButtonType.OK).showAndWait();
        e.printStackTrace();
    }
}