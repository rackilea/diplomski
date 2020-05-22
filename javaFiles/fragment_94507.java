enum ClientHelper {
    USER_TYPE_1(new A()),
    USER_TYPE_2(new B());

    private ClientHelper(... obj) {
    }

    public String getX(String id) {
        ...
    }

}