class XAxisData {
    private List<Object[]> ticks;

    public XAxisData(List<Object[]> xAxisLocations) {
        this.ticks = xAxisLocations;
    }

    public List<Object[]> getTicks() {
        return ticks;
    }

    public void setTicks(List<Object[]> ticks) {
        this.ticks = ticks;
    }
}