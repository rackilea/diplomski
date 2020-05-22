insert( new Result( "error", "2528" ) );
  insert( new Result( "message", "Header Account must not be null" ) );
  modify( cAccount ) {
      setErrorCode( "2528" )
  }
  System.out.println("Header Account null check called");