public class Variable extends Monomial {

    final private String m_varName;

    public Variable( String varName ) {
        this.m_varName = varName;
    }

    @Override
    public Monomial add( RingElem e ) {
        if ( e instanceof Variable ) {
            if ( e.equals( this ) ) {
                return new Monomial( new Constant( 2 ) , this , new Constant( 1 ) );
            }
            else {
                throw new RuntimeException( "Operation would create a polynomial, which is not defined yet!" );
            }
        }
        else if ( e instanceof Monomial ) {
            throw new RuntimeException( "Operation would create a polynomial, which is not defined yet!" );
        }
        else {
            throw new RuntimeException( "operation not defined!" );
        }
    }

    @Override
    public Monomial multiply( RingElem e ) {
        if ( e instanceof Constant ) {
            Constant c = ( Constant ) e;
            return c.multiply( this );
        }
        if ( e instanceof Variable ) {
            return new Monomial( (Variable) e , this , new Constant( 1 ) );
        }
        else {
            return this.multiply( e );
        }
    }

    @Override
    public String toString() {
        return this.m_varName;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o instanceof Variable ) {
            Variable v = ( Variable ) o;
            return this.m_varName.equals( v.m_varName );
        }
        else {
            return false;
        }
    }
}