public ChildFoo extends Foo {

   private int key;

   public ChildFoo(ChildFoo that) {
     super(that);
     this.key = that.key;
   }
 }