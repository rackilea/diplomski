public Counter() {
    this.id = nextId();
    this("Unnamed counter");        
}
public Counter(String name) {
    this.id = nextId();
    this.name = name;
}