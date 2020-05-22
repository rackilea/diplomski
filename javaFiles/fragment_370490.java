class DimensionComparator implements Comparator<Dimension> {
    private static double area(Dimension d) {
        return d.getWidth() * d.getHeight();
    }

    public int compare(Dimension d1, Dimension d2) {
        return Double.compare(area(d1), area(d2));
    }
}