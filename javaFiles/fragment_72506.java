interface GraphNodes {        
    public Node getMasterUser();
    public Node getMasterFilter();
    public Node getMasterLocation();
}

interface GraphIndexes {
    public Index getIndexUser();
    public Index getIndexFilter();
}

class Graph implements GraphNodes, GraphIndexes {
    private Node masterUser;
    private Node masterFilter;
    private Node masterLocation;
    private Index indexUser;
    private Index indexFilter;

    public GraphNodes getNode() { return this; }
    public GraphIndexes getIndex() { return this; }

    public Node getMasterUser() { return this->masterUser; }
    public Node getMasterFilter() { return this->masterFilter; }
    public Node getMasterLocation() { return this->masterLocation; }
    public Index getIndexUser() { return this->indexUser; }
    public Index getIndexFilter() { return this->indexFilter; }
}