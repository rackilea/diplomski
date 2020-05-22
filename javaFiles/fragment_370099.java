// OPTION 1 with constructor
private static class POJO{
    private String name;

    public POJO(String name) {
        this.name = name;
    }
}

// OPTION 2 with factory method
private static class POJO{
    private String name;

    @JsonCreator
    public static POJO POJO(String name) {
        POJOlink = new POJO();
        link.name = name;
        return link;
    }
}