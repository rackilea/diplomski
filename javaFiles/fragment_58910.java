public class Class {
    @JsonIgnore
    Map<String,String> firstMap;
    @JsonIgnore
    Map<String,String> secondMap;

    Map<String,String> compositeMap

    @JsonAnyGetter
    public Map<String, String> getCompositeMap() {
        return compositeMap;
    }

    @JsonAnySetter
    public void setCompositeMap(Map<String, String> compositeMap) {
        this.compositeMap = compositeMap;
    }

}