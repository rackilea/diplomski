public abstract class Mover<T extends Position> {
  public abstract T move(T originalPosition ); 
}

public class ComplicatedMover extends Mover<ComplicatedPosition> {
  public ComplicatedPosition move(ComplicatedPosition p) {
    //do stuff
  }
}