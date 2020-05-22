datad.nodeProperty().addListener(new ChangeListener<Node>() {
            @Override
            public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
                newNode.setStyle("-fx-bar-fill: red;");


            }
        });