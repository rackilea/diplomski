class Container{
    static int next_id = 0; 
    final int id = next_id++;
    final Node<Container> node;
    State state;

    public Container() {
        node = new Node<>(this);
        setState(State.one);
    }

    public void setState(State state) {
        if(this.state != null) node.unlink();
        this.state = state;
        if(this.state != null) this.state.containers.add(node);
    }
}

enum State{
    one, two, three, four, five;
    final List<Container> containers = ...;
}