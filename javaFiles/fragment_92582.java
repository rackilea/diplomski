Dialog<Product> dialog = new Dialog<>();
dialog.setTitle("Product Dialog");
dialog.setResizable(true);

Label nameLabel = new Label("Name: ");
Label priceLabel = new Label("Price: ");
TextField nameField = new TextField();
TextField priceField = new TextField();

GridPane grid = new GridPane();
grid.add(nameLabel, 1, 1);
grid.add(nameField, 2, 1);
grid.add(priceLabel, 1, 2);
grid.add(priceField, 2, 2);
dialog.getDialogPane().setContent(grid);

ButtonType saveButton = new ButtonType("Save", ButtonData.OK_DONE);
dialog.getDialogPane().getButtonTypes().add(saveButton);

dialog.setResultConverter(new Callback<ButtonType, Product>() {
    @Override
    public Product call(ButtonType button) {
        if (button == saveButton) {
            String name = nameField.getText();
            Float price;
            try {
                price = Float.parseFloat(priceField.getText());
            } catch (NumberFormatException e) {
                // Add some log or inform user about wrong price
                return null;
            }

            return new Product(name, price);
        }

        return null;
    }
});

Optional<Product> result = dialog.showAndWait();

if (result.isPresent()) {
    Product product = result.get();
    // Do something with product
}