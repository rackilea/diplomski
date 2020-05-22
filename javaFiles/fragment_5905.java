public void setType(String type) {
    try {
        this.type = Enum.valueOf(Type.class, type.toUpperCase());
    } catch (IllegalArgumentException e) {
        this.type = Type.STRING;
    }
}