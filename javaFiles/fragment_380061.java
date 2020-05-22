@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "type")
public abstract class AbstractMessage {
}

public class TestMessage extends AbstractMessage {
  private String message;
  ...
}

public class TestOther extends AbstractMessage {
  private int other;
  ...
}

public class TestSomethingElse extends AbstractMessage {
  private boolean justSomethingElse;
  ...
}