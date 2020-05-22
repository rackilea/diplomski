DragSource.getDefaultDragSource().addDragSourceMotionListener(new DragSourceMotionListener() {
    @Override
    public void dragMouseMoved(DragSourceDragEvent dsde) {
        System.out.println("DRAGMOUSEMOVED");
    }
});