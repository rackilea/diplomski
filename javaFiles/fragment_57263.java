public class Test {

    Map<Integer, Item> items = new LinkedHashMap<Integer, Item>();

    // HashMap have method values(), but not property values.
    public List<Item> getValues() {
        return new ArrayList<Item>(items.values());
    }

    public abstract class Item {

        public abstract Object getValue();

        public abstract void setValue(Object value);

    }

    public class ItemInt extends Item {

        private Integer value;

        public Integer getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = (Integer) value;
        }
    }

    public class ItemFloat extends Item {

        private Float value;

        public Float getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = (Float) value;
        }
    }


    public Test() {

        ItemInt value = new ItemInt();
        value.setValue(1);
        items.put(0, value);


        ItemFloat itemFloat = new ItemFloat();
        itemFloat.setValue(4f);
        items.put(1, itemFloat);

    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Test test = new Test();

        Object property = new PropertyUtilsBean().getProperty(test, "values[0].value");
        System.err.println("" + property.getClass());
    }

}