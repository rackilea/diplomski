ParallelTransition pt = new ParallelTransition();

    RotateTransition rx=new RotateTransition(Duration.seconds(5), this);
    rx.setAxis(Rotate.X_AXIS);

    RotateTransition rz=new RotateTransition(Duration.seconds(5), this);
    rz.setAxis(Rotate.Z_AXIS);

    rx.setFromAngle(0);
    rx.setToAngle(90*xrotate);

    rz.setFromAngle(0);
    rz.setToAngle(90*zrotate);

    pt.getChildren().addAll(rz,rx);

    pt.play();