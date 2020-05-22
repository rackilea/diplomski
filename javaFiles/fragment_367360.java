class Entity {
  List<Element> elements = new ArrayList<>();

  Element getElement( int index ) {
    if( index < 0 || index >= elements.size() ) {
      return null; //out of range, i.e. no such element
    }

    return elements.get(index);
  } 
}