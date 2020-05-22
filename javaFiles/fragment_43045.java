class BaseBuilder<B extends BaseBuilder>{
    protected final StringBuilder bldr = new StringBuilder();
    private Class<B> builderImplementationClass;

    protected BaseBuilder( Class<B> builderImpl ){
        builderImplementationClass = builderImpl;

        if( this.getClass() != builderImpl )
            throw new IllegalStateException( "Should match." );
    }

    B addValue( String name, String value ){
        bldr.append( name ).append( '=' ).append( value )append( ',' );
        return builderImplementationClass.cast( this );
    }

    String toString(){
        return bldr.toString();
    }
}

class IntBuilder extends AbstractBuilder<IntBuilder>{

    public IntBuilder(){
        super( IntBuilder.class );
    }

    IntBuilder addValue( String name, int value ){
        bldr.append( name ).append( '=' ).append( value )append( ',' );
        return this;
    }
}