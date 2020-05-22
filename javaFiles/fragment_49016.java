for(int count = 0; count < lineCount; ++count) {
  lines[count].draw(g);
}

if( currentLine != null ) {
  //you could set different rendering options here, e.g. a different color
  currentLine.draw(g); 
}