public static void fadeOutAndDispose(final Window window,
        int fadeOutDuration) {
    fadeOutAndEnd(window, fadeOutDuration, false);
}

public static void fadeOutAndExit(Window window, int fadeOutDuration) {
    fadeOutAndEnd(window, fadeOutDuration, true);
}

private static void fadeOutAndEnd(final Window window, int fadeOutDuration, 
        final boolean exit) {
    Timeline dispose = new Timeline(new WindowFader(window));
    dispose.addPropertyToInterpolate("opacity", 1.0f,
            0.0f);
    dispose.addCallback(new UIThreadTimelineCallbackAdapter() {
        @Override
        public void onTimelineStateChanged(TimelineState oldState,
                TimelineState newState, float durationFraction,
                float timelinePosition) {
            if (newState == TimelineState.DONE) {
                if (exit) {
                    Runtime.getRuntime().exit(0);
                } else {
                    window.dispose();
                }
            }
        }
    });
    dispose.setDuration(fadeOutDuration);
    dispose.play();
}

public static class WindowFader {
    private Window window;

    public WindowFader(Window window) {
        this.window = window;
    }

    public void setOpacity(float opacity) {
        AWTUtilitiesWrapper.setWindowOpacity(window, opacity);
    }
}