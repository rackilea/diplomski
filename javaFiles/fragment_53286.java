Comparator<String> cmp = new Comparator<WaterBody>() {
    @Override
    public int compare(WaterBody o1, WaterBody o2) {
        return Double.compare(o1.getElectricPower(), o2.getElectricPower());
    }
};