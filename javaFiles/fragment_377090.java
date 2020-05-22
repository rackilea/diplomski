tableShop.setRowFactory(table-> {
        return new TreeTableRow<Product>(){
            @Override
            public void updateItem(Product pers, boolean empty) {
                super.updateItem(pers, empty);      
                boolean isTopLevel = table.getRoot().getChildren().contains(treeItemProperty().get());
                if(pers==null||empty) {
                    setText(null);
                    setGraphic(null);
                    getStyleClass().remove("topLevelRow");
                }else {
                    if(isTopLevel) {
                        if(!getStyleClass().contains("topLevelRow")) {
                            getStyleClass().add("topLevelRow");
                        }
                    }else {
                        getStyleClass().remove("topLevelRow");
                    }
                }
            }
        };
    });