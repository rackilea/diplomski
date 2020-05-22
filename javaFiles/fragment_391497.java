public B() {
    super();                        <---\
    this.id = 42;                   <---|
    System.out.println("A created");<---|-----replaced super(42)
    System.out.println("B created");<---/
    System.out.println("B created with default id 42");
}