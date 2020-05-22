public class Constant extends Monomial {

    private double m_val;

    public Constant( double val ) {
        super();

        this.m_val = val;
    }

    @Override
    public Constant add ( RingElem e ) {
        if ( e instanceof Constant ) {
            Constant c = ( Constant ) e;
            return new Constant( this.m_val + c.m_val );
        }
        else if ( e instanceof Variable ) {
            throw new RuntimeException( "Operation would create a polynomial, which is not defined yet!" );
        }
        else {
            throw new RuntimeException( "Operation not defined" );
        }
    }

    @Override
    public Monomial multiply( RingElem e ) {
        if ( e instanceof Constant ) {
            Constant c = ( Constant ) e;
            return new Constant( this.m_val * c.m_val );
        }
        else if ( e instanceof Variable ) {
            return new Monomial( this.clone() , (Variable) e , new Constant( 1 ) );
        }
        else {
            throw new RuntimeException( "Operation not defined" );
        }
    }

    @Override
    public String toString() {
        return String.valueOf( this.m_val );
    }

    @Override
    public boolean equals( Object o ) {
        if ( o instanceof Constant ) {
            Constant c = ( Constant ) o;
            return this.m_val == c.m_val;
        }
        else {
            return false;
        }
    }

    @Override
    public Constant clone() {
        return new Constant( this.m_val );
    }
}