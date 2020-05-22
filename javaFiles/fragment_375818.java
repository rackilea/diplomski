int s  = 40;//preview scale factor
int w  = 8;//pixels width
int h  = 8;//pixels height
int np = w*h;//total number of pixels 
int b = 255;//current pixel brush brightness
float nb = 0;//normal image brightness
float mb = 64;//max brightness
float db = 0;//dimmed image brightness

int[][] normal,dimmed;

void setup(){
  noSmooth();fill(127);
  size(w*s*2,h*s);
  normal = new int[w][h];
  dimmed = new int[w][h];
}
void draw(){
  background(0);//clear
  for(int y = 0; y  < h ; y++){
    for(int x = 0; x < w ; x++){
      fill(normal[x][y]);
      rect(x*s,y*s,s,s);//draw a scaled pixel representation
      fill(dimmed[x][y]);
      rect((x*s)+(w*s),y*s,s,s);
    }
  }
  fill(127);text("original brightness: "+nb+" max: " + mb +"\ndimmed brightness: " + db,10,15);
}
void mouseDragged(){
  if((mouseX > 0 && mouseX < w*s)&&(mouseY > 0 && mouseY < h*s)){
    normal[mouseX/s][mouseY/s] = b;
    //average brightness
    nb = getBrightness(normal);
    //dimm if needed
    float bd   = (nb-mb)/255.0;//normalized brightness difference
    println(nb-mb+"/"+bd);

    for(int y = 0; y  < h ; y++)
      for(int x = 0; x < w ; x++)
        dimmed[x][y] = normal[x][y] - (int)(bd > 0 ? bd * 255.0 : 0);
    //done dimming, compare
    db = getBrightness(dimmed);
  }
}
void keyPressed(){
  if(key == '-' && b > 0) b--;
  if(key == '=' && b < 255) b++; 
  if(key == ' ') {
    for(int y = 0; y  < h ; y++)
      for(int x = 0; x < w ; x++)
        normal[x][y] = 0;
  }
}
float getBrightness(int[][] img){
  float ab = 0;
  for(int y = 0; y  < h ; y++)
    for(int x = 0; x < w ; x++)
      ab += img[x][y];
  return (ab/np);
}