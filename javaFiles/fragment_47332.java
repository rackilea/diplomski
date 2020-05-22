while (Mouse.next()){
    if (Mouse.getEventButtonState()) {
        if (Mouse.getEventButton() == 0) {
            System.out.println("Left button pressed");
        }
    }else {
        if (Mouse.getEventButton() == 0) {
            System.out.println("Left button released");
        }
    }
}