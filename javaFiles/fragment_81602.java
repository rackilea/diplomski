public abstract class Employee {
  private final Id id;
  private final Name name;

  // Package private constructor in sub-classable class.
  Employee(Id id, Name name, ...) {
    // Defensively copy as necessary.
  }
}

public final class Accountant extends Employee {
  // Public constructos allowed in final sub-classes.
  public Accountant(Id id, Name name, ...) {
    super(id, name, ...);  // Call to super works from same package.
  }
}

public final class ITWorker extends Employee {
  // Ditto.
  public ITWorker(Id id, Name name, ...) {
    super(id, name, ...);
  }
}