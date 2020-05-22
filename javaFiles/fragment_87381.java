public enum RestrictFields {
    R1((source, target) -> {
        target.setA(source.getA());
        target.setB(source.getB());
        target.setC(source.getC());
    }), 
    R2((source, target) -> {
        target.setD(source.D());
    });

    private final BiConsumer<MyObj, MyObj> copier;

    private RestrictFields (final BiConsumer<MyObj, MyObj> copier) {
        this.copier = copier;
    }

    public void copy(final MyObj source, final MyObj target){
        this.copier.accept(source, target);
    }
}