public abstract class ImmutableList< T > {
    public interface Converter< U, V > {
        V convert( U u );
    }

    public abstract < U > ImmutableList< U > map( Converter< ? super T, ? extends U > cnv );

    public static class EmptyIL< T > extends ImmutableList< T >{
        @Override
        public < U > EmptyIL< U > map( Converter< ? super T, ? extends U > cnv ) {
            return new EmptyIL< U >();
        }
    }

    public static class NonEmptyIL< T > extends ImmutableList< T > {
        private final T tHead;
        private final ImmutableList< ? extends T > ltTail;
        public NonEmptyIL( T tHead, ImmutableList< ? extends T > ltTail ) {
            this.tHead = tHead;
            this.ltTail = ltTail;
        }
        @Override
        public < U > NonEmptyIL< U > map( Converter< ? super T, ? extends U > cnv ) {
            return new NonEmptyIL< U >( cnv.convert( tHead ), ltTail.map( cnv ) );
        }
    }

    public < U > ImmutableList< U > add( U u, final Converter< ? super T, ? extends U > cnv ) {
        return new NonEmptyIL< U >( u, map( cnv ) );
    }

    public static < V > Converter< V, V > id() {
        return new Converter< V, V >() {
            @Override public V convert( V u ) {
                return u;
            }
        };
    }

    public static < W, U extends W, V extends W > Converter< W, W > sup( U u, V v ) {
        return id();
    }

    static class Rock {}
    static class Hominid {}
    static class Human extends Hominid {}
    static class Monkey extends Hominid {}
    static class Chimpanzee extends Monkey {}

    public static void main( String[] args ) {
        Monkey monkey = new Monkey();
        Human human = new Human();
        Rock rock = new Rock();

        // id() should suffice, but doesn't
        new EmptyIL< Chimpanzee >().
            add( monkey, ImmutableList.< Monkey >id() ).
            add( human, ImmutableList.< Hominid >id() ).
            add( rock, ImmutableList.< Object >id() );

        // sup() finds the supremum of the two arguments' types and creates an identity conversion
        // but we have to remember what we last added
        new EmptyIL< Chimpanzee >().
            add( monkey, sup( monkey, monkey ) ).
            add( human, sup( monkey, human ) ). // add( human, sup( monkey, monkey ) ) also works
            add( rock, sup( human, rock ) );
    }
}