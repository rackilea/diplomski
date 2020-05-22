/** Used for workaround for Vaadin issue #8858
 *  'Binder.bindInstanceFields() overwrites existing bindings'
 *  https://github.com/vaadin/framework/issues/8858
 */
private final Map<String, Component> manualBoundComponents = new HashMap<>();
...
// Commented here and declared local below for workaround for Vaadin issue #8858 
//private final TextField siblingsCount = new TextField( "№ of Siblings" );
...

public ChildView() {
    ...

    // Workaround for Vaadin issue #8858
    // Declared local here to prevent processing by Binder#bindInstanceFields() 
    final TextField siblingsCount = new TextField( "№ of Siblings" );
    manualBoundComponents.put( "siblingsCount", siblingsCount );
    binder.forField( siblingsCount )
            .withNullRepresentation( "" )
            .withConverter( new StringToIntegerConverter( Integer.valueOf( 0 ), "integers only" ) )
            .bind( Child::getSiblingsCount, Child::setSiblingsCount );
    binder.bindInstanceFields( this );

    ...

    // Workaround for Vaadin issue #8858  
    addComponent( manualBoundComponents.get( "siblingsCount" ) );
    //addComponent( siblingsCount );

    ...
}