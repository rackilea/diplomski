public G testIt() {
    C c = new C();
    c.setP(2);
    P p = c;
    G g = new G(p);
    return g;
}