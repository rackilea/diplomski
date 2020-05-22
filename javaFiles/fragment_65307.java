@Override
public void updateSelected(boolean selected) {
    super.updateSelected(selected);
    setGraphic(selected ? selectedCell : defaultCell);
}



@Override
protected void updateItem(String s, boolean b) {
    super.updateItem(s, b);

    if(s == null || b) {
        setContentDisplay(ContentDisplay.TEXT_ONLY);
        setGraphic(null);
    }
    else {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(isSelected() ? selectedCell : defaultCell);
    }
}