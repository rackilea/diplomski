public enum GearType implements ConfigurationParameter {
    Automatic("Automatic"), Manual("Manual");

    private String type;

    GearType(String _type) {
        type = _type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public void doSomeFunction(Object caller) {
        //TODO function code
    }
}