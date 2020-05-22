class MyList<T> implements List<T>
{
  T firstValue;

  public MyList( T value )
  {
     firstValue = value;
  }
}

Apple apple = new Apple( );

// This compiles fine, and now we have a problem
// Hence the warning
MyList<Orange> foo = new MyList( apple );

// This does not compile
MyList<Orange> foo = new MyList<Apple>( apple );

// Nor this in Java 7
MyList<Orange> foo = new MyList<>( apple );