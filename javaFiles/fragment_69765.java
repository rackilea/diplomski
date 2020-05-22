public class MyConstructor extends Constructor {
    public MyConstructor() {
        this.yamlConstructors.put(new Tag("!intarr"),
                                  new ConstructIntegerArray());
    }

    private class ConstructIntegerArray extends AbstractConstruct {
        public Object construct(Node node) {
            final List<Object> raw = constructSequence(node);
            final Integer[] result = new Integer[raw.size()];
            for(int i = 0; i < raw.size(); i++) {
                result[i] = (Integer) raw.get(i);
            }
            return result;
        }
    }
}