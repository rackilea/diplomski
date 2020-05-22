class PieChartRendererWithImages extends PieChartRenderer
{
  protected Drawable mImage;

  public PieChartRendererWithImages(PieChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler, Drawable image) {
    super(chart, animator, viewPortHandler);
    mImage = image;
  }

  /**
   * This draws an image before all pie-slices
   *
   * @param c
   */
  protected void drawImageBeforeSlice(Canvas c) {

    IPieDataSet dataSet = mChart.getData().getDataSet();

    if (!dataSet.isVisible())
      return;

    float phaseX = mAnimator.getPhaseX();
    float phaseY = mAnimator.getPhaseY();

    MPPointF center = mChart.getCenterCircleBox();
    float r = mChart.getRadius();

    // calculate the radius of the "slice-circle"
    float circleRadius = (r - (r * mChart.getHoleRadius() / 100f)) / 2f;

    float[] drawAngles = mChart.getDrawAngles();
    float angle = mChart.getRotationAngle();

    for (int j = 0; j < dataSet.getEntryCount(); j++) {

      float sliceAngle = drawAngles[j];

      Entry e = dataSet.getEntryForIndex(j);

      // draw only if the value is greater than zero
      if ((Math.abs(e.getY()) > Utils.FLOAT_EPSILON)) {

        float x = (float) ((r - circleRadius)
                * Math.cos(Math.toRadians((angle + sliceAngle)
                * phaseY)) + center.x);
        float y = (float) ((r - circleRadius)
                * Math.sin(Math.toRadians((angle + sliceAngle)
                * phaseY)) + center.y);

        // draw image instead of arcs            
        Utils.drawImage(
                c,
                mImage,
                (int)x,
                (int)y,
                mImage.getIntrinsicWidth(),
                mImage.getIntrinsicHeight());
      }

      angle += sliceAngle * phaseX;
    }
    MPPointF.recycleInstance(center);
  }

  @Override
  public void drawExtras(Canvas c) {
    super.drawExtras(c);
    // use drawImageBeforeSlice in last step of rendering process
    drawImageBeforeSlice(c);
  }
}