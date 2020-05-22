for( int i = 0; i < array.length; i++ ) {
    String[] parts = array[i].split(' ');
    if( parts.length == 2 ) {
        array[i] = parts[1];
    }
}