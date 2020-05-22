Button btn = new Button("Hover Me!");

btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event 1 with Convenience Method"); 
    }
});
btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event 2 with Convenience Method"); 
    }
});
btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event 1 with addEventHandler"); 
    }
});

btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event 2 with addEventHandler"); 
    }
});