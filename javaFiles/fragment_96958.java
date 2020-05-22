optionsButton.setChangeListener(new FieldChangeListener() {
            public void fieldChanged(Field arg0, int arg1) {
                PopupScreen popup = new PopupScreen(new VerticalFieldManager());
                popup.add(new LabelField("Hello!"));
                Border border = BorderFactory.createSimpleBorder(
                new XYEdges(), Border.STYLE_TRANSPARENT);
                popup.setBorder(border);

                Uiapplication.getUIapplication.pushScreen(popup);
            }
        });