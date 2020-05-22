private void initGraphics(){
    pointer = new Path();
    pointer.setFill(pointerColour.get());
    pointer.setStrokeWidth(0);
    pointer.getElements().add(new MoveTo(50, 50));
    pointer.getElements().add(new LineTo(50, 200));
    pointer.getElements().add(new LineTo(200, 200));
    pointer.getElements().add(new ClosePath());
    pointer.relocate(70, 70);
    pointer.getTransforms().add(new Scale(2, 2, 50, 50));
}