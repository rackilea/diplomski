while(!g.allShipsPlaced())
{
    NumberGenerator gen = new NumberGenerator();
    AbstractShipFactory battleFactory = new BattleShipFactory();
    ...
    g.addShip(battleFactory.createShip(gen.rand(), gen.rand(), gen.rand()));
    ...
}