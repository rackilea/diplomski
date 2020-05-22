// Load the image with the needed size
Image image = new Image("...", 150, 150, true, true);

// Place it over a Button
Button button = new Button();

Tooltip tooltip = new Tooltip();
tooltip.setGraphic(new ImageView(image));

button.setTooltip(tooltip);