class Container{
    static int next_id = 0; 
    final int id = next_id++;
    State state;

    public Container() {
        setState(State.one);
    }

    public void setState(State state) {
        if(this.state != null) this.state.containers.remove(id);
        this.state = state;
        if(this.state != null) this.state.containers.put(id, node);
    }
}

enum State{
    one, two, three, four, five;
    final Map<Integer, Container> containers = new HashMap<>();
}