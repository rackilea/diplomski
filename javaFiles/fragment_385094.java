PImage[] images = new PImage[20];
images[0] = loadImage(...);
//..load rest of images

for(int i = 0; i < 20; i += i){
  image(blabla, blabla, images[i]);
}