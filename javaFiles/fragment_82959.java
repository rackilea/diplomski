Point2D anchorPoint = node.localToScreen(
        node.getWidth() / 2,
        node.getHeight()
);

popup.setAnchorLocation(
        PopupWindow.AnchorLocation.WINDOW_TOP_LEFT
);

popup.show(
        node,
        anchorPoint.getX(),
        anchorPoint.getY()
);