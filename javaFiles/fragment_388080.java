class Node1 implements Comparable<Node1> {
    String start, end;
    double cost;

    public Node1(String start, String end, double cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public Node1(double cost) { // alternate constructor to store cost in   priority queue
        this.cost = cost;
    }

    public String getStartNode(){
        return start;
    }

    public String getEndNode(){
        return end;
    }

    public double getCost(){
        return cost;
    }

    @Override
    public int compareTo(Node1 o) {
        return Double.compare(this.cost, o.cost);
    }
}