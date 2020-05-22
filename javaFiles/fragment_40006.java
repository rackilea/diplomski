public interface CarConfig {       
    @PropertyName("default.color")
    @DefaultValue("red")
    String getDefaultColor();

    void setDefaultColor(String color);

    @PropertyName("max.size")
    @DefaultValue(100)
    int getMaxSize();

    void setMaxSize(int size);

    ...
}