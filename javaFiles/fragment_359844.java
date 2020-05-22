public class Monomial implements RingElem< Monomial > {

    private Monomial m_coefficient;

    private Monomial m_base;

    private Monomial m_exponent;

    public Monomial() {

    }

    public Monomial( Monomial coefficient , Monomial base , Monomial exponent ) {
        if ( base.m_coefficient != null ) {
            this.m_coefficient = coefficient.multiply( base.m_coefficient );
            if ( base.m_base != null ) {
                this.m_coefficient = coefficient.multiply( base.m_base );
            }
        }
        else {
            this.m_coefficient = coefficient;
        }
        this.m_exponent = exponent;
        this.m_base = base;
    }

    @Override
    public Monomial add( RingElem< Monomial > e ) {
        if ( e instanceof Monomial ) {
            Monomial addend = (Monomial) e;
            if ( this.m_base.equals( addend.m_base ) && this.m_exponent.equals( addend.m_exponent ) ) {
                Monomial rtn = new Monomial( this.m_coefficient.add( addend.m_coefficient ) , this.m_base , this.m_exponent );
                return rtn;
            }
            else {
                throw new RuntimeException( "Addition would produce a polynomial, which is not implemented yet!" );
            }
        }
        else {
            throw new RuntimeException( "Operation not defined" );
        }
    }

    @Override
    public Monomial multiply( RingElem< Monomial > e ) {
        if ( e instanceof Constant ) {
            Constant c = ( Constant ) e;
            return new Monomial( this.m_coefficient.multiply( c ) , this.m_base , this.m_exponent );
        }
        else if ( e instanceof Monomial ) {
            Monomial m = ( Monomial ) e;
            return new Monomial( this.m_coefficient.multiply( m.m_coefficient ).multiply( m.m_base ) , this.m_base , this.m_exponent.add( m.m_exponent ));
        }
        else {
            throw new RuntimeException( "Operation not defined" );
        }
    }

    @Override
    public String toString() {
        if ( this.m_coefficient == null || this.m_base == null || this.m_exponent == null ) {
            return "<error>";
        }
        return this.m_coefficient.toString() + this.m_base.toString() + "^" + this.m_exponent.toString();
    }

    final public static void main( String[] args ) {
        String[] letters = { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z" };
        Variable[] v = new Variable[ letters.length ];
        for ( int i=0 ; i<letters.length ; i++ ) {
            v[ i ] = new Variable( letters[ i ] );
        }
        Monomial coefficient = new Constant( 1.2 );
        Monomial exponent = new Constant( 4.5 );
        Monomial test = new Monomial( coefficient , v[ 0 ] , exponent );
        for ( int i=1 ; i<letters.length ; i++ ) {
            test = test.multiply( new Constant( 1.2 ) );
            test = new Monomial( test , v[ i ] , new Constant( (int)(Math.random() * 25 )) );
        }
        System.out.println( test.toString() );
    }

    @Override
    public boolean equals( Object o ) {
        if ( o instanceof Monomial ) {
            Monomial m = ( Monomial ) o;
            return this.m_coefficient.equals( m.m_coefficient ) && this.m_base.equals( m.m_base ) && this.m_exponent.equals( m.m_exponent );
        }
        else {
            return false;
        }
    }
}