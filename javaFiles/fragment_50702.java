// A unique dispatcher
final static Events events = new Events();

// Somewhere, an observer is interested by collision events 
CollisionListener observer = ...
events.listen( Collision.class, observer );

// there is some moving parts        
Spaceship aShip = ...
Meteor aMeteor = ...

// Later they collide => a collision event is notified trough the dispatcher
events.notify( new Collision( aShip, aMeteor  ) );