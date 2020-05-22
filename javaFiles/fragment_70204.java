Button selectAll = new Button("Select all");
selectAll.setOnAction(e -> {
    for (AttributeRow row : attributeTable.getItems()) {
        for (String group : groups) {
            row.setActive(group, true);
        }
    }
});