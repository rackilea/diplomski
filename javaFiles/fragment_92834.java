deleteBtn.addClickHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
        TextBox tb = (TextBox) table.getWidget(row - 1, 0);
        DeleteFish(tb.getText());
    }
});