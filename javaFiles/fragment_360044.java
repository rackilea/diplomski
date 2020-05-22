public enum Element {
    HYDROGEN(.1f),
    CARBON(.28f);

    private final float radius;

    private Element(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}