class Root {

    @JsonDeserialize(converter = MapMyHolderConverter.class)
    private List<MyHolder> propertyName;

    //getters,setters,toString
}

class MyHolder {

    private String name;
    private String age;
    private boolean female;

    //getters,setters,toString
}