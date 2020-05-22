// nombres = collections2, miClasses = collection1
nombres.addAll(Collections2.transform(miClasses, new Function() {
    @Override
    public String apply (MiClasse miClasse) {
        return miClasse.nombre();
    }
}));