private final List< Entity > toBeRemoved = new LinkedList<>();

public void update(GameContainer gc, int delta) {
   toBeRemoved.clear();
   for( Entity entity : entities ) {
      if( entity.update( gc, delta )) {
         toBeRemoved.add( entity );
      }
   }
   entities.removeAll( toBeRemoved );
}