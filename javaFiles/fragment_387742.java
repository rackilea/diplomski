class Position {
  double x;
  double y;

  Position( x, y ) {
    this.x = x;
    this.y = y;
  }
}

public Unit(String name, Position initialPosition, int weight, int strength, int agility, int toughness, 
    int currentHealth, int currentStamina ) { ... }

//call:
new Unit( "myname", new Position(1.0, 2.0), ... );