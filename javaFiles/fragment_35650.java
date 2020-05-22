addButton.setOnAction((event)->{
    addButton.setDisable(true);
    data.add(new Book(String.valueOf(newBookIndex),"test"));

    VirtualFlow vf=(VirtualFlow)lv.lookup(".virtual-flow");
    if(!lv.lookup(".scroll-bar").isVisible()){
        FadeTransition f = new FadeTransition();
        f.setDuration(Duration.seconds(1));
        f.setFromValue(0);
        f.setToValue(1);
        f.setNode(vf.getCell(lv.getItems().size()-1));
        f.setOnFinished(t->{
            newBookIndex++;
            addButton.setDisable(false);                        
        });
        f.play();
    } else {
        PauseTransition p = new PauseTransition(Duration.millis(20));
        p.setOnFinished(e->{
            vf.getCell(lv.getItems().size()-1).setOpacity(0);
            vf.show(lv.getItems().size()-1);
            FadeTransition f = new FadeTransition();
            f.setDuration(Duration.seconds(1));
            f.setFromValue(0);
            f.setToValue(1);
            f.setNode(vf.getCell(lv.getItems().size()-1));
            f.setOnFinished(t->{
                newBookIndex++;
                addButton.setDisable(false);                        
            });
            f.play();
        });
        p.play();
    }
});