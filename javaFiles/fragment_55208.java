Creatable<MyObject> creator = () ->  {
    try {
        return new MyObject();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
};