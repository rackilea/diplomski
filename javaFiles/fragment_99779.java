private final TextField siblingsCount = new TextField( "№ of Siblings" );

...

binder.forField( siblingsCount )
    .withNullRepresentation( "" )
    .withConverter(
        new StringToIntegerConverter( Integer.valueOf( 0 ), "integers only" ) )
    .bind( Child::getSiblingsCount, Child::setSiblingsCount );
binder.bindInstanceFields( this );