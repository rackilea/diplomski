class PojoClass {

    property1;
    ...
    propertyN;

    @override
    public int hashcode() {
        //implementation
    }

    @override
    public boolean equals(Object o) {
        //implementation
    }

    @override
    public String toString)() {
        return new Gson().toJson(this);
    }

}