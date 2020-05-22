class GraphNode {
    private int start;
    private int end;
    private int cost;

    public GraphNode(int start, int end, int cost) {                
            this.start = start;
            this.end = end;
            this.cost = cost;
    }

    public int getStart() {
            return start;
    }

    public void setStart(int start) {
            this.start = start;
    }

    public int getEnd() {
            return end;
    }

    public void setEnd(int end) {
            this.end = end;
    }

    public int getCost() {
            return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}