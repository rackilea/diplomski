vertex.add(new Vertex(1)); //internally, it will be looked if array is big enoguh and then the add method will do its work

...

public void add(Vertex v) {
    //add into vertices
    ...
    v.add(this);
}