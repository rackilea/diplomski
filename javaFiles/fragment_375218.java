for( Circle circle : circles ) {
  if( circle.wasHit(x, y) {
    if( circle.isValid() ) {
      //do what you'd need here, e.g. change the shape to a rectangle
    } else {
      //error
    }

    //break the loop since other circles can't be hit or we're not interested in those
    break;
  }
}