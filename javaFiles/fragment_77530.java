public Box(String name, int Size){
    this.setName(name);
    this.setSize(Size);
    top = new ArrayList<Box>();
    bottom = new ArrayList<Box>();
}