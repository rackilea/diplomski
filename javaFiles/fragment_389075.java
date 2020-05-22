Command.start();
Command.command( "line 1" );
Thread.sleep( 2000 );
Command.command( "line 2" );
Thread.sleep( 2000 );
Command.command( "line 3" );
Command.terminate();