public void cutoffFoos(  Timestamp fooTime) throws Exception {
  ... Code that gets fooList ...
  if( fooList != null ) {
      for( Foo foo: fooList ) {
          for( Bar bar : foo.getBarList() ) {
               ... Code that does things with existing Barlist ...
               sess.flush();
               if( ... ) {
                   ... Code that makes new Bar object ...
                   foo.getBarList().add(bar2);
               }
          }
          sess.flush();
          sess.update( foo );
      }
  }
}