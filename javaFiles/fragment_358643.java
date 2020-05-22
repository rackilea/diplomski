//stage.setResizable(true);

Screen screen = Screen.getPrimary();    
Rectangle2D bounds = screen.getVisualBounds();

stage.setX(bounds.getMinX());
stage.setY(bounds.getMinY());
stage.setWidth(bounds.getWidth());
stage.setHeight(bounds.getHeight());