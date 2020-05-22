pane.setOnMouseClicked(e -> {

        if ( e.getTarget().getClass() == Circle.class ) {
            deleteCircle((Circle)e.getTarget());
        } else {
            Circle circle = makeCircle(e.getX(), e.getY());// using the makeCircle method to draw the circle where the mouse is at the click
            pane.getChildren().add(circle);
            redrawPolygon();
        }

    });