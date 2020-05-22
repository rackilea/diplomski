public class MyClass {
    ObjectType type;
    String someValue;

    public void setType(ObjectType thisType) {
        this.type = thisType;
        this.someValue = thisType.getSomeValue();
    }

    enum ObjectType {
        ball ("This is a ball"),
        bat ("This is a bat"),
        net ("This is a net");

        private final String someValue;

        ObjectType(String someValue) {
            this.someValue = someValue;
        }

        public String getSomeValue() {
            return someValue;
        }
    }
}