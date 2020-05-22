class Attribute {

    private double value;

    public Attribute(String attrName, Number attrValue) {
        this.name = attrName;
        this.value = attrValue.doubleValue();
    }

}