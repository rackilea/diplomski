plot.setRenderer(new MyRender());
...
class MyRender extends BarRenderer {

    @Override
    public Paint getItemPaint(int row, int col) {
        System.out.println(row + " " + col + " " + super.getItemPaint(row, col));
        return super.getItemPaint(row, col);
    }
}