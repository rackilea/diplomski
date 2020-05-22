class ChildClass {

    static String preprocessParams(Map<String, Object> params) {
        ...
        return someString;
    }

    public BaseClass(Map<String, Object> params) {
        super(preprocessParams(params));
    }
}