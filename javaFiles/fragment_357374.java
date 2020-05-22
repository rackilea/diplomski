function showFileDialog() {
    applet.showFileDialog( function( filepath ) {
       if( filepath ) {
          alert( "Hey they picked " + filepath );
       } // must have hit cancel if filepath is null
    } );
}