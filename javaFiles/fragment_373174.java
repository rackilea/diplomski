private enum Direction implements EnumType {
    NORTH, EAST, SOUTH, WEST;

    @Override
    public String getLiteral() {
        return this.name();
    }

    @Override
    public Schema getSchema() {
        return MY_SCHEMA;
    }

    @Override
    public String getName() {
        return "direction";
    }
}