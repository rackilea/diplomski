interface YourType {
  Set<Capability> myCapabilities();
}

enum Capability {
  SERIALIAZABLE,
  SYNCHRONOUS,
  IMMUTABLE,
  BUFFERED //whatever - hey, this is just an example, 
           //don't throw everything in of course!
}