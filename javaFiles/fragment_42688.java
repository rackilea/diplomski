public static class Container {
    private List<Group> groups;
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    @Override
    public String toString() {
        return String.format("Container [groups=%s]", groups);
    }
}

@JsonDeserialize(using=CustomDeserializer.class)
public static class Group {
    String id;
    List<Integer> values;
    @Override
    public String toString() {
        return String.format("Group [id=%s, values=%s]", id, values);
    }
}