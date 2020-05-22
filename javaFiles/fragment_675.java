void loadCard(int cols, int rows, int w, int x,int y,String lines[],PImage flag) {

  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {

      //draw default so ellipse / img has a background
      fill(23,  159,  215);
      rect(x, y, w, w);

      //draw other cases on top of default    
      if(lines[i].charAt(j) == '1'){
        fill(156,  158,  162);
        rect(x, y, w, w);
      }
      else if(lines[i].charAt(j) == '2'){
        fill(225,  169,  26) ;
        ellipse(x,y,w/2,w/2);
      }
      else if(lines[i].charAt(j) == '3'){
        image(flag,x,y,w/2,w/2);
      }
      x = x + w ;
    }
    y = y + w ;
    x = 0 ;
  }
}