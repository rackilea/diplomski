public static void main(String[] args)
{
    List<AdminResource> resources = Arrays.asList(new AdminResource("Sport", Arrays.asList(1)),
                                                  new AdminResource("Football", Arrays.asList(1, 2)),
                                                  new AdminResource("Estonia", Arrays.asList(1, 2, 3)));

    AdminNode root = new AdminNode(new AdminResource("ROOT", Collections.emptyList()));

    resources.forEach(root::addResource);

    for (AdminResource r : root)
    {
        System.out.println(r.getId());
    }
}

public static class AdminNode
    implements Iterable<AdminResource>
{
    private AdminResource   resource;
    private List<AdminNode> children;

    public AdminNode(AdminResource resource)
    {
        this.resource = resource;
        this.children = new ArrayList<>();
    }

    public void addResource(AdminResource resource)
    {
        addResource(resource, new LinkedList<>(resource.getPath()));
    }

    private void addResource(AdminResource resource, Queue<Integer> path)
    {
        if (path.size() > 1)
        {
            Integer nextParent = path.poll();
            for (AdminNode child : children)
            {
                if (child.getResource().getId().equals(nextParent))
                {
                    child.addResource(resource, path);
                }
            }
        }
        else
        {
            children.add(new AdminNode(resource));
        }
    }

    public AdminResource getResource() { return resource; }

    @Override
    public Iterator<AdminResource> iterator()
    {
        return stream().iterator();
    }

    public Stream<AdminResource> stream()
    {
        return goDown(this).skip(1).map(AdminNode::getResource);
    }

    private static Stream<AdminNode> goDown(AdminNode node)
    {
        return Stream.concat(Stream.of(node), node.children.stream().flatMap(AdminNode::goDown));
    }
}

public static class AdminResource
{
    private Integer       id;
    private String        resource;
    private List<Integer> path;

    public AdminResource(String resource, List<Integer> path)
    {
        this.id = path.isEmpty() ? null : path.get(path.size() - 1);
        this.resource = resource;
        this.path = path;
    }

    public Integer getId() { return id; }
    public List<Integer> getPath() { return path; }
}