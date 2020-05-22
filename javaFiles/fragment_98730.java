listView.setCellFactory(factory -> {
    CheckBoxListCell<Model> cell = new CheckBoxListCell<Model>() {
        // a listener on the graphicProperty: it installs the "real" listener
        InvalidationListener graphicListener = g -> {
            // installs the "real" listener on the graphic control once it is available 
            registerUIListener();
        };

        {
            // install the graphic listener at instantiation
            graphicProperty().addListener(graphicListener);
        }

        /** method to install a listener on a property of the graphic control
         * and unregisters the initially installed listener
         */
        private void registerUIListener() {
            if (!(getGraphic() instanceof CheckBox)) throw new IllegalStateException("checkBox expected");
            graphicProperty().removeListener(graphicListener);
            ((CheckBox) getGraphic()).selectedProperty().addListener(
                    (observable, oldValue, newValue) -> listView.getSelectionModel().select(getItem()));
        }
    };
    cell.setSelectedStateCallback(Model::selectedProperty);
    return cell;
});