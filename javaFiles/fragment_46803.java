final DragAndDrop dragAndDrop = new DragAndDrop();
dragAndDrop.addSource(new DragAndDrop.Source(sourceImage) {
    public DragAndDrop.Payload dragStart (InputEvent event, float x, float y, int pointer) {
        DragAndDrop.Payload payload = new DragAndDrop.Payload();
        payload.setDragActor(sourceImage);
        dragAndDrop.setDragActorPosition(-x, -y + sourceImage.getHeight());
        return payload;
    }
    public void dragStop (InputEvent event, float x, float y, int pointer, Target target) {
        sourceImage.setBounds(50, 125, sourceImage.getWidth(), sourceImage.getHeight());
        if(target != null) {
            sourceImage.setPosition(target.getActor().getX(), target.getActor().getY());
        }
        virtualStage.addActor(sourceImage);
    }
});