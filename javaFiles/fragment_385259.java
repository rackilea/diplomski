stage.setOnCloseRequest((WindowEvent event1) -> {
    try {
        closebackuptaskandshowmaintask(event1);
    }catch (Exception ex) {
        Logger.getLogger(FXMLReflectUIController.class.getName()).log(Level.SEVERE, null, ex);
    }
});