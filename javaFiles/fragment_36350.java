class CompositeHello implements IHello {
    IHello[] Hellos;

    CompositeHome(IHello...hellos) {
        super();
        this.hellos = hellos;
    }

    void setAttribute(int value) {
        for (IHello hello : hello) {
            home.setAttribute(value);
        }
    }
}