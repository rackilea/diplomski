class Wrapper extends SomeForeignClass {
    final SomeForeignClass sfc;

    Wrapper(SomeForeignClass _sfc) {
         sfc = _sfc;
    }

    @Override
    void anApiMethod(String aString) {
        if ( condition() )
             sfc.anApiMethod(aString);
        else
             anAlternateMethod(aString);
    }

    /* ... etc ... */
}