JFXNodesList buttonsNode = new JFXNodesList();
        buttonsNode.setRotate(-90); // to the right 
        JFXButton val1 = new JFXButton("1") ;
        JFXButton val2 = new JFXButton("2") ;
        JFXButton val3 = new JFXButton("3") ;
        val1.setStyle("-fx-background-color: salmon");
        val2.setStyle("-fx-background-color: lightblue");
        val3.setStyle("-fx-background-color: lightgreen");
        buttonsNode.addAnimatedNode(val1);
        buttonsNode.addAnimatedNode(val2);
        buttonsNode.addAnimatedNode(val3);