// if current not roughly equal to target
if( Math.abs(targetStroke - currentStroke) > STROKE_DELTA ) {
    // move towards target by the increment
    if( targetStroke > currentStroke )
        currentStroke = Math.min(targetStroke, currentStroke + STROKE_INCREMENT);
    else
        currentStroke = Math.max(targetStroke, currentStroke - STROKE_INCREMENT);
    mPath.lineTo(mX, mY);

    mPath = new Path();
    mPath.moveTo(mX,mY);
    mPaths.add(mPath);
    mStrokes.add(currentStroke);
}