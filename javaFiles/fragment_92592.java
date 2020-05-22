table.addCellPreviewHandler(new Handler<MyObject>() {
    @Override
    public void onCellPreview(CellPreviewEvent<MyObject> event) {
        if ("click".equals(event.getNativeEvent().getType())) {
            if (event.getNativeEvent().getCtrlKey()) {
                // CTRL button was pressed during the click
            }
        }
    }
});