public class Project {
    private int projectId;
    private Set<Organization> clients;

    public void addClient(Organization org){
        if(clients==null){
            clients=new HashSet<Organization>();
        }
        org.setProject(this);
        clients.add(org);
    }
}

public class Organization{
    private int organizationId;
    private Project project;       //if bi-directional relation is required.
}