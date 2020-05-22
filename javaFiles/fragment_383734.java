public void test() {
  from(Customer.class).where(c -> c.getAge() > 20).select(Customer::getUserName);
}

public <T> Builder<T> from(Class<T> cls) {
  return new Builder<>(cls);
}

public class Builder<T> {
  private Class<T> cls;

  public Builder(Class<T> cls) {
    this.cls = cls;
  }

  public Builder<T> where(Predicate<T> predicate) {
    // store predicate
    return this;
  }

  public Builder<T> select(Function<T, Object> field) {
    // store field selector
    return this;
  }
}

public class Customer {
  private String userName;
  private int age;

  public int getAge() {
    return age;
  }

  public String getUserName() {
    return userName;
  }
}