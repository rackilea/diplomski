Player p = Manager.createRealizedPlayer( f.toURI().toURL() );

BufferControl bc = (BufferControl) p.getControl( "javax.media.control.BufferControl" );
if ( bc != null )
  bc.setBufferLength( 500 ); // buffer length specified in milliseconds

p.start();
System.out.println( "Player playing" );

Thread.sleep( 1000 );
System.out.println( " Clip is at time: " + p.getMediaTime().getSeconds() );

p.stop();
System.out.println( " Clip is at time: " + p.getMediaTime().getSeconds() );