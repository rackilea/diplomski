if (startTime < 0) {
    startTime = System.currentTimeMillis();
}
long now = System.currentTimeMillis();
long duration = now - startTime;
double t = (double) duration / (double) playTime;
if (duration >= playTime) {
    t = 1;
}

double progress = splineInterpolator.interpolate(t);

x = startAt + ((int) Math.round((endAt - startAt) * progress));
repaint();