class Position
{
  private int[][] data;
  public boolean equals(Position other) { .. }
}

interface Positionable
{
  public Position getPosition();
}

class Character implements Positionable
{
  private Position position;
  @Override public Position getPosition() { return position; }
}

class EntityGroup
{
  List<Positionable> entities;

  public Optional<Positionable> findEntityInSamePosition(Positionable p) {
    return entities.stream().filter(p2 -> !p.equals(p2) && p.getPosition().equals(p2.getPosition())).findfirst();

  }
}