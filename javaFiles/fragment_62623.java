private DragGestureRecognizer dgr;
    private DragGestureHandler dragGestureHandler;

    @Override
    public void addNotify() {

        super.addNotify();

        if (dgr == null) {

            dragGestureHandler = new DragGestureHandler(this);
            dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(
                    this,
                    DnDConstants.ACTION_MOVE,
                    dragGestureHandler);

        }

    }

    @Override
    public void removeNotify() {

        if (dgr != null) {

            dgr.removeDragGestureListener(dragGestureHandler);
            dragGestureHandler = null;

        }

        dgr = null;

        super.removeNotify();

    }