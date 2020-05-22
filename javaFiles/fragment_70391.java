public ChildFoo(Foo that) {
     // call the copy constructor of Foo -> no problem
     super(that);

     // but how to initialize this.key? A Foo instance has no key value!
     // Maybe use a default value?
     this.key = 0;
 }