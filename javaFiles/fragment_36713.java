XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(){
    Stroke soild = new BasicStroke(2.0f);
    Stroke dashed =  new BasicStroke(1.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] {10.0f}, 0.0f);
    @Override
    public Stroke getItemStroke(int row, int column) {
if (row == 2){
  double x = dataset.getXValue(row, column);
  if ( x > 4){
    return dashed;
  } else {
    return soild;
  } 
} else
  return super.getItemStroke(row, column);
    }
  };
  renderer.setBaseShapesVisible(true);
  renderer.setBaseShapesFilled(true);
  renderer.setBaseStroke(new BasicStroke(3));
  plot.setRenderer(renderer);