This works                         This doesn't work
-------------------------------------------------------------

static Foo shared;                 static Foo shared;

class Foo                          class Foo
{                                  {   
    final int i;                       final int i; 
    Foo()                              Foo() 
    {                                  {
        i = 1;                             i = 1;
                                           shared = this;  
    }                                  }
}                                  }

shared = new Foo();                new Foo();