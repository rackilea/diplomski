class Shape {
  protected static abstract
  class BuilderBase<T extends BuilderBase<T, S>, S extends Shape> {
    /** all subclasses should implement {@code self()} as {@code return this;} */
    abstract T self();
    public T setLocation(double x, double y) {
        // ...
        return self();
    }
    public T setFooBar(FooBar x) {
      // ...
      return self();// the more methods you have the more useful self() becomes
  }

    public abstract S build();
  }

  protected Shape(/*...*/) {/*...*/}
}

class Circle extends Shape {
  public static class Builder extends BuilderBase<Builder, Circle> {
    @Override final Builder self() { return this; }

    public Builder setRadius(double radius) {
        //...
        return this;
    }

    @Override
    public Circle build() { return new Circle(/*...*/); }
  }

  private Circle(/*...*/) {/*...*/}
}

class Rectangle extends Shape {
  public static class Builder extends BuilderBase<Builder, Rectangle> {
    @Override final Builder self() { return this; }

    public Builder setRadius(double radius) {
      //...
      return this;
    }

    @Override
    public Rectangle build() { 
      return new Rectangle(/*...*/); 
    }
  }

  public Rectangle(/*...*/) {/*...*/}
}