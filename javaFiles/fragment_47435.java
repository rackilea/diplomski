private List<Lado> lados;

@Override
public List<Lado> lados() {
    // Type of lados is List<Lado>, but we will fill it up with Arista instances...
    lados = new LinkedList<Lados>();
    lados.add(new Arista());
    // if Arista has methods that follow the with setter stereotype, ie: public Arista withId(int id) { this.setId(id); return this; } you can in-line create them:
    lados.add(new Arista()
              .withId(id)
              .withName(name)
    );
    Arista arista = new Arista();
    lados.add(arista);
    ...
    return lados;
}