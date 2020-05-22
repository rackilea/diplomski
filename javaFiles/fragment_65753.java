searchRS.last(); 
rsLength = searchRS.getRow();
if ( rsLength < 1 ) 
{ 
    return contactListQuery( 0 ); 
}