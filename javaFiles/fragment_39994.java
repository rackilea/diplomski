/** Main constructor. */
public Foo(int maxActive, 
           byte whenExhaustedAction, 
           int minIdle, 
           boolean testOnBorrow, 
           boolean lifo) 

/** Convenience constructor. */
public Foo(boolean lifo)
{
  this(1, 0x01, 3, false, lifo);    // call the main constructor will default values
}