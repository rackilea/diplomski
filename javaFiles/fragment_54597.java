PathTransition pt = new PathTransition();
pt.setDuration(Duration.millis(2000));
pt.setPath(big); // Make this change
pt.setNode(bigRec);
pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
pt.setCycleCount(Timeline.INDEFINITE);
pt.setAutoReverse(false);