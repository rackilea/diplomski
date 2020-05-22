ByteBuffer byteBuffer = ByteBuffer.allocate( 100 );
byteBuffer
        // explicitly converting each char into 2 bytes
        .put( ( byte ) ( 'H' >>> 8 ) ).put( ( byte ) 'H' ) 
        .put( ( byte ) ( 'e' >>> 8 ) ).put( ( byte ) 'e' )
        .put( ( byte ) ( 'l' >>> 8 ) ).put( ( byte ) 'l' )
        .put( ( byte ) ( 'l' >>> 8 ) ).put( ( byte ) 'l' )
        .put( ( byte ) ( 'o' >>> 8 ) ).put( ( byte ) 'o' );
// flipping the buffer to be able access the current content via get operations
byteBuffer.flip();
// reinterpreting the byte sequence as a char sequence
CharBuffer charBuffer = byteBuffer.asCharBuffer();
System.out.println( charBuffer.toString() );