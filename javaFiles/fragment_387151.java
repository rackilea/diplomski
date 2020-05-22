class Super { 
  public <T> void set( T arg) { ... } 
  public <T> T get() { ... } 
} 
class Sub extends Super { 
  public void set( Object arg) { ... } // overrides 
  public Object get() { ... }    // overrides with unchecked warning 
}