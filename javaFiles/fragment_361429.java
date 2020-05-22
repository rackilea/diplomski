public class Packet { }
public interface Handleable {
  public void handle();
}

public class DummyPacket extends Packet implements Handleable {
  @Override
  public void handle() {
    // Do something
  }
}

public class OtherPacket extends Packet implements Handleable {
  @Override
  public void handle() {
    // Do something else
  }
}

public class LastPacket extends Packet { }