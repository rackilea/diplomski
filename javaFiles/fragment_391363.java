public void setItemID( String itemID )
{
    this.itemID.set( "0" );
    int id = Integer.parseInt( itemID );
    this.itemID.set( String.format( "%04d", id ) );
}