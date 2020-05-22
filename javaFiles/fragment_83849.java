public class Team {

    private String name;
    private Set<Employee> members;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ValidCollection(elementType=Employee.class)
    public Set<Employee> getMembers() { return members; }
    public void setMembers(Set<Employee> members) { this.members = members; }

}