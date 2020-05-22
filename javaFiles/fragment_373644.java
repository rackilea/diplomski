private void moveCameraTo(Point p) {
        KeyValue yVal = new KeyValue(this.scrollPane.vvalueProperty(),
                p.getY(),
                Interpolator.EASE_BOTH);
        KeyValue xVal = new KeyValue(this.scrollPane.hvalueProperty(),
                p.getX(),
                Interpolator.EASE_BOTH);
        Timeline yTimeline = TimelineBuilder.create().autoReverse(false)
                .keyFrames(new KeyFrame(DEFAULT_TRANSITION_TIME, yVal)).build();
        Timeline xTimeline = TimelineBuilder.create().autoReverse(false)
                .keyFrames(new KeyFrame(DEFAULT_TRANSITION_TIME, xVal)).build();

        yTimeline.play();
        xTimeline.play();
    }