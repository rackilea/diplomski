interface EndoFunctor<X extends Type, T extends EndoFunctor<X, T>> extends Type {
    <Y extends Type> EndoFunctor<Y, ?> fmap(Function<X,Y> map, T fx);    
}

class Id<X extends Type> implements EndoFunctor<X, Id<X>> {
    protected X witness;
    Id(X witness) { this.witness = witness; }

    @Override
    public <Y extends Type> Id<Y> fmap(Function<X, Y> map, Id<X> fx) {
        return new Id<>(map.apply(fx.witness));
    }
}