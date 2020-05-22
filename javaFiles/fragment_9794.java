private void DrawTrail(Canvas canvas) {
    if(trail.size() > 1) {
        float prevWidthHalfX = 0f, prevWidthHalfY = 0f, prevX = 0f, prevY = 0f;
        Path trailStepRect = new Path();
        boolean isFirst = true;
        for (int i = 0; i < TRAIL_DRAW_POINT; i++) {
            float currWidthHalf = (float) (radius) * i / TRAIL_DRAW_POINT / 2f,
                    currWidthHalfX = currWidthHalf * trailTans[i][1],
                    currWidthHalfY = currWidthHalf * trailTans[i][0],
                    currX = trailPoss[i][0], currY = trailPoss[i][1];
            if (!isFirst) {
                trailStepRect.reset();
                trailStepRect.moveTo(prevX - prevWidthHalfX, prevY + prevWidthHalfY);
                trailStepRect.lineTo(prevX + prevWidthHalfX, prevY - prevWidthHalfY);
                trailStepRect.lineTo(currX + currWidthHalfX, currY - currWidthHalfY);
                trailStepRect.lineTo(currX - currWidthHalfX, currY + currWidthHalfY);
                canvas.drawPath(trailStepRect, trailPaints[i]);
            } else {
                isFirst = false;
            }
            prevX = currX;
            prevY = currY;
            prevWidthHalfX = currWidthHalfX;
            prevWidthHalfY = currWidthHalfY;
        }
    }
}