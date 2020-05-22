IModel<String> colorModel = new Model<>();
queue(new TextField<String>("colorpicker", colorModel) {
            @Override
            protected String[] getInputTypes() {
                return new String[] {"color"};
            }
        });
queue(new Label("colorlabel", colorModel));