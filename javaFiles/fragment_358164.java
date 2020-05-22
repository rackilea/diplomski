Class NodeSet {
    Set<Node> set = new TreeSet<Node>();

    public Node findNode(int id) {  
        Iterator<Node> iterator = set.iterator();
        while(iterator.hasNext()) {
            Node node = iterator.next();
            if(node.getId() == id)             
                return node;
        }

        return null;                
    }
}