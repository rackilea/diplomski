ComboBoxListViewSkin<T> comboBoxListViewSkin = new ComboBoxListViewSkin<T>(comboBox);
comboBoxListViewSkin.getPopupContent().addEventFilter(KeyEvent.ANY, (event) -> {
    if( event.getCode() == KeyCode.SPACE ) {
        event.consume();
    }
});
comboBox.setSkin(comboBoxListViewSkin);