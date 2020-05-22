class Phrase {

    private String label;
    private String domain;

    @JsonAdapter(StringWrapperJsonDeserializer.class)
    @SerializedName("synonymlabels")
    private List<String> synonymLabels;

    @JsonAdapter(StringWrapperJsonDeserializer.class)
    @SerializedName("childrenlabels")
    private List<String> childrenLabels;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<String> getSynonymLabels() {
        return synonymLabels;
    }

    public void setSynonymLabels(List<String> synonymLabels) {
        this.synonymLabels = synonymLabels;
    }

    public List<String> getChildrenLabels() {
        return childrenLabels;
    }

    public void setChildrenLabels(List<String> childrenLabels) {
        this.childrenLabels = childrenLabels;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "label='" + label + '\'' +
                ", domain='" + domain + '\'' +
                ", synonymLabels=" + synonymLabels +
                ", childrenLabels=" + childrenLabels +
                '}';
    }
}