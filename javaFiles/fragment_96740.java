class Project {
    private String name;

    @JsonSerialize(using = ImagePathJsonSerializer.class)
    private Image image;

    //getters, setters
}