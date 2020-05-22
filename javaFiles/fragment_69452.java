ServletFileUpload upload = new ServletFileUpload();
FileItemIterator iter = upload.getItemIterator( request );

while ( iter.hasNext() ) {
    FileItemStream item = iter.next();
    String name = item.getFieldName();
    InputStream stream = item.openStream();

    if ( item.isFormField() ) {
        byte[] buffer = new byte[ 128 ];
        int len = stream.read( buffer );
        String value = new String( buffer, 0,len );
        if ( name.equals( "name" ) ) {
            filename  = value;
        }
        System.err.println( "Form field " + name + " with value " + value + " detected." );
        stream.close();
    }
}