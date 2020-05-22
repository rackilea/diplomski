@Override
protected void initializeGraphicalViewer() {

    super.initializeGraphicalViewer();
    final GraphicalViewer viewer = getGraphicalViewer();
    viewer.setContents(getModel());
    ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) viewer.getRootEditPart();

    Viewport viewport = (Viewport) rootEditPart.getFigure();
    viewport.getUpdateManager().performUpdate();
    viewport.setViewLocation(getModel().getZoomPosition());
}