private StringProperty model;


public Model(int id, String name, List<Item> item){
    this.id=id;
    this.name=name;
    this.item = item;
    model = new StringProperty(getName()+" "+getId());
}

public void setName(String name) {
    this.name = name;
    model.set(getName()+" "+getId());
}

public StringProperty modelProperty() {
    return new StringProperty(getName()+" "+getId);
}