mainContainer.setOnMouseDragged(new EventHandler<MouseEvent>()
{
    @Override
    public void handle(MouseEvent event)
    {
        if (mouseKoordinates.get() != null)
        {
            double x = event.getX();
            double deltaX = x - mouseKoordinates.get().getX();
            double y = event.getY();
            double deltaY = y - mouseKoordinates.get().getY();
            mainSt.setX(mainSt.getX() + deltaX);
            mainSt.setY(mainSt.getY() + deltaY);
        }
    }
});