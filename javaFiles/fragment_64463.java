beginShape(LINES);
  for(int k = 0; k < 200; k+= 40){
    vertex(hw, height);vertex(i+k, 30);
    vertex(hw, height);vertex(j-k, 30);
  }
  endShape();