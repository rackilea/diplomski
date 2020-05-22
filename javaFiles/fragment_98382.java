private static class MyGenerator implements XYItemLabelGenerator {

    @Override
    public String generateLabel(XYDataset dataset, int series, int item) {
        return "Series " + series + " Item " + item;
    }
}