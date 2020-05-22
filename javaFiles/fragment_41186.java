SnapshotParameters params = new SnapshotParameters();
        params.setViewport(
            new Rectangle2D(
                selection.getX(),
                selection.getY(),
                selection.getWidth(),
                selection.getHeight()));

        root.getChildren().remove(selection);
        WritableImage image = root.snapshot(params, null);