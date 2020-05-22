SortedSet<Node> nodeSet = new TreeSet<Node>(new Comparator<Node>() {
    public int compare(Node node1, Node node2) {

        if (node1.getParent() == null) {
            if (node2.getParent() == null) {
                return  node1.getId().compareTo(node2.getId());
            }
            return -1;
        }

        if (node2.getParent() == null) return 1;

        int parentCompare = node1.getParent().getId()
                .compareTo(node2.getParent().getId());

        if (parentCompare == 0)
            return node1.getId().compareTo(node2.getId());

        return parentCompare;
    }
});

nodeSet.addAll(allData); // allData is the Node list


Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();

for(Node node : nodeSet)
{
    if(map.get(node)==null)
    {
        map.put(node, new ArrayList<Node>());
    }
    map.get(node).add(node);
    Node parentNode = node.getParent();
    while(parentNode!=null)
    {
        map.get(parentNode).add(node);
        parentNode = parentNode.getParent();
    }
}

// At this point I can get an element from map and see all children in values.