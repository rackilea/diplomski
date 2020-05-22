colID.setOnEditCommit(event -> {
    String newValue = event.getNewValue();
    if(checkUniqueness(newValue)){
        event.getRowValue().setSID(newValue);
    }else {
        event.getRowValue().setSID(null);
    }

    //Weird FX Bug - on the second time through, the value was set, but the table
    //column didn't repaint, showing the incorrect amount.
    colID.setVisible(false);
    colID.setVisible(true);
});

//Stream the backing collection for the table and look for the value that needs to be unique

public boolean checkUniqueness(String value) {
        return backingCollection
            .stream()
            .noneMatch(item -> item.getSID().equals(value));
    }