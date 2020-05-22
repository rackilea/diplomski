Button btn = new Button("Hover Me!");

btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event with Convience Method"); 
    }
});
btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
    public void handle(MouseEvent event) {
        System.out.println("Handling event with addEventHandler"); 
    }
});