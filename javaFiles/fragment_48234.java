IModel<Color> colorModel = new Model<>();
queue(new TextField<Color>("colorpicker", colorModel, Color.class) {
            @Override
            protected String[] getInputTypes() {
                return new String[] {"color"};
            }
        });
queue(new Label("red", colorModel.map(Color::getRed)));
queue(new Label("green", colorModel.map(Color::getGreen)));
queue(new Label("blue", colorModel.map(Color::getBlue)));