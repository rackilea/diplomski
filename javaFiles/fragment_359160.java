List<Entity> entities = new ArrayList<Entity>();

public void render(GameContainer gc, Graphics g, Camera camera) {
   background.draw(0 - camera.getX(), 0 - camera.getY(), 2100, 2100);
   for( Entity entity : entities ) {
      if( entity.isVisible( player, gc )) {
         entity.render( gc, g );
      }
   }
}

public void update(GameContainer gc, int delta) {
   for( Entity entity : entities ) {
      entity.update( gc, delta );
   }
}