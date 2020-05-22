RotateAnimation rotate = new RotateAnimation(fromRotation, toDegrees,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(1000);


    rotate.setFillAfter(true);
    pt.startAnimation(rotate);