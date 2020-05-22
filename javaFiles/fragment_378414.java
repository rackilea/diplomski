for (Iterator<Pixel> iterator = pixels.iterator(); iterator.hasNext(); ) {
  Pixel px = iterator.next();
  if(px.y > gHeigh){
    iterator.remove();
  }
}