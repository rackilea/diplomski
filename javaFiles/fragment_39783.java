private static class MyRenderer extends XYLineAndShapeRenderer {

    @Override
    public boolean getItemShapeVisible(int series, int item) {
        System.out.println(series + ":" + item);
        if (item % 2 == 0) return false;
        else return super.getItemShapeVisible(series, item);
    }
}