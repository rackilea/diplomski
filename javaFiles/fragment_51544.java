hb.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
{
    System.out.println("Middle Clicked?" + event.getButton()== MouseButton.MIDDLE);
    System.out.println("Primary Clicked?" + event.getButton()== MouseButton.PRIMARY);
    System.out.println("Secondary Clicked?" + event.getButton()== MouseButton.SECONDARY);
    System.out.println("None Clicked?" + event.getButton()== MouseButton.NONE);
}