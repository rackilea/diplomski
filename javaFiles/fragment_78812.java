public void methodForTheCondition() {
    if (<some condition>) {
        List<XYZ> l = genericMethod(XYZ.class);
        // do something
    } else {
        List<ABC> l = genericMethod(ABC.class);
        // do something else, which I assume is different, otherwise opt for
        // a common interface
    }
}

public <T> List<T> genericMethod(Class<T> clazz) {
    List<T> result = new ArrayList<T>();
    return result;
}