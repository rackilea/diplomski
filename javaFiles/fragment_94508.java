enum ClientHelper {
    USER_TYPE_1() {
        A a = new A();

        @Override
        public String getX(String id) {
             ...
        }
    },
    USER_TYPE_2() {
        ...
    };

    public abstract String getX(String id);

}

String x = ClientHelper.USER_TYPE2.getX("H");