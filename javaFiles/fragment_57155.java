void removeFromWorld(Animal a) {
    a.accept(new Visitor() {
        public void visitGiraffe(Giraffe g) {
            setOfGiraffes.remove(g);
        }
        public void visitZebra(Zebra z) {
            setOfZebras.remove(z);
        }
    });
}