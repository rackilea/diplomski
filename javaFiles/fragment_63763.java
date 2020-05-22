/**
 * Sets a new editor factory used by the PropertySheet to determine which
 * {@link PropertyEditor} to use for a given {@link Item}.
 * @param factory 
 */
public final void setPropertyEditorFactory( Callback<Item, PropertyEditor<?>> factory ) {
    propertyEditorFactory.set( factory == null? new DefaultPropertyEditorFactory(): factory );
}