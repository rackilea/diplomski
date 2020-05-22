public interface scala.collection.immutable.Set<A>
    extends 
        scala.collection.immutable.Iterable<A>, 
        scala.collection.Set<A> {
    public abstract scala.collection.generic.GenericCompanion<scala.collection.immutable.Set> companion();
    public abstract <B> scala.collection.immutable.Set<B> toSet();
    public abstract scala.collection.immutable.Set<A> seq();
    public abstract scala.collection.parallel.Combiner<A, scala.collection.parallel.immutable.ParSet<A>> parCombiner();
}