gridItem.addComponentColumn(item -> {
            Label label = new Label();
            label.setValue(item.getText());
            label.setWidthUndefined();
            label.setStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
            return label;
        })
        .setCaption("Item")
        .setWidth(380.0);