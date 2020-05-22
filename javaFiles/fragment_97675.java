interface Borough extends NamedLocation{ ... }
interface City extends NamedLocation{ 
  ... 
  // the city is much more than a collection of boroughs,
  // but it HAS them
  Collection<Borough> getBoroughs();
}