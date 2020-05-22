XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(){
        @Override
        public Paint getItemPaint(int row, int col) {
            Paint cpaint = getItemColor(row, col);
            if (cpaint == null) {
                cpaint = super.getItemPaint(row, col);
            }
            return cpaint;
        }

    public Color getItemColor(int row, int col) {
        System.out.println(col + "," + dataset.getY(row, col));
        double y = dataset.getYValue(row, col);
        if(y<=3) return Color.black;
        if(y<=4) return Color.green;;
        if(y<=5) return Color.red;;
        if(y<=6) return Color.yellow;;
        if(y<=10) return Color.orange;;
        return null;
    }

    @Override
    protected void drawFirstPassShape(Graphics2D g2, int pass, int series,
        int item, Shape shape) {
        g2.setStroke(getItemStroke(series, item));
        Color c1 = getItemColor(series, item);
        Color c2 = getItemColor(series, item - 1);
        GradientPaint linePaint = new GradientPaint(0, 0, c1, 0, 300, c2);
        g2.setPaint(linePaint);
        g2.draw(shape);
    }
};