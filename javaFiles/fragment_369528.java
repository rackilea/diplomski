class CustomObjectConstructor extends Constructor {
    public CustomObjectConstructor() {
        this.yamlConstructors.put(new Tag("!customObject"), new ConstructCustomObject());
    }

    private class ConstructCustomObject extends AbstractConstruct {
        public Object construct(Node node) {
            final Map<Object, Object> values = constructMapping(node);
            final String a = (String) values.get("a");
            final String b = (String) values.get("b");
            final String c = (String) values.get("c");
            return new CustomObject(a + ":" + b + "/" + c);
        }
    }
}