class Wrapper extends SomeForeignClass {

    Wrapper(SomeForeignClass _sfc) {
        super(_sfc.getEntity() );
    }

    @Override
    void anApiMethod(String aString) {
        if ( condition() )
             super.anApiMethod(aString);
        else
             anAlternateMethod(aString);
    }
}