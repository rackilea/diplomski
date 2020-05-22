private void FillTrail() {
    trailPath.reset();
    boolean isFirst = true;
    for(Point p : trail) {
        if(isFirst) {
            trailPath.moveTo(p.x, p.y);
            trailPoss[0][0] = p.x;
            trailPoss[0][1] = p.y;
            isFirst = false;
        } else {
            trailPath.lineTo(p.x, p.y);
        }
    }
    PathMeasure path = new PathMeasure(trailPath, false);
    float step = path.getLength() / TRAIL_DRAW_POINT;
    for(int i=0; i<TRAIL_DRAW_POINT; i++) {
        path.getPosTan(step * i, trailPoss[i], trailTans[i]);
    }
}