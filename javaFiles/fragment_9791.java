static final int TRAIL_MAX_COUNT = 50; //maximum trail array size
static final int TRAIL_DRAW_POINT = 30; //number of points to split the trail for draw

private ConcurrentLinkedQueue<Point> trail;
private Paint[] trailPaints;
private float[][] trailPoss, trailTans;
private Path trailPath;