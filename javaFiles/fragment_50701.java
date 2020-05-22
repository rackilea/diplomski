public final class Collision implements GameEvent<CollisionListener> {

   private final Spaceship ship;
   private final Meteor meteor;

   public Collision( final Spaceship aShip, final Meteor aMeteor ) {
      this.ship = aShip;
      this.meteor = aMeteor;
   }

   public void notify( final CollisionListener listener) {
      listener.spaceshipCollidedWithMeteor( ship, meteor );
   }

}