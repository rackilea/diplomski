private Object createObjectNotInitialized( String name ){
   return new Object();
}

private Object createObjectInitialized( String name ){
  Object newObj = new Object();
  newObj.setName( name );
  return newObj;
}

public Object createObject( String name, boolean doInit ){
  if( doInit ){
     return createObjectInitialized(name);
  }else{
     return createObjectNotInitialized(name);
  }
}

// you can chose to init objects by default - I chose not to for this example
public Object createObject( String name ){
     return createObjectNotInitialized(name);
}