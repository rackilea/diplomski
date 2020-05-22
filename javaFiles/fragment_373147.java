public class MyClass {

    @Expose
    private String type;

    @Expose
    private List<MyOtherClass> groups = new ArrayList<MyOtherClass>();

    public String getType() {
       return type;
    }

    public void setType(String type) {
       this.type = type;
    }

    public List<Group> getGroups() {
       return groups;
    }

    public void setGroups(List<Group> groups) {
       this.groups = groups;
    }

}