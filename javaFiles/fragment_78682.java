class MetaObject {
    public List<Integer> objects;

    @JsonDeserialize(using = MetaDeserializer.class)
    public String meta;

    @Override
    public String toString() {
        return "MetaObject{" + "objects=" + objects + ", meta='" + meta + '\'' + '}';
    }
}