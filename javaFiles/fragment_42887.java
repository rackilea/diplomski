import SimpleOpenNI.*;

SimpleOpenNI  context;

int[] sceneMap;//this will store data about the scene (bg pixels will be 0, and if there are any users, they will have the value of the user id - e.g. if there are no users, the array will be filled with zeros, if there is one user, some array entries will be equal to 1, etc. the size of the array is the same as the number of pixels in scene image, so it's easy to use with the pixels[] of a PImage
PImage myUserImage;//this is where we'll draw the user
int user1Colour = color(180,130,30);//change to whatever you like

void setup()
{
  context = new SimpleOpenNI(this);
  context.enableScene();

  background(200,0,0);
  size(context.sceneWidth() , context.sceneHeight());
  //set scene map array
  sceneMap = new int[context.sceneWidth()*context.sceneHeight()];
  //create the image to draw the user into, by default it will be filled black
  myUserImage = createImage( context.sceneWidth() , context.sceneHeight(), RGB );
}

void draw()
{
  context.update(); 

  // // gives you a label map, 0 = no person, 0+n = person n - tell OpenNI to update the numbers in the array
  context.sceneMap(sceneMap);
  //clear myUserImage - fill everything with black
  Arrays.fill(myUserImage.pixels,color(0));//We've never used Arrays.fill() before, but all it does is it loops through all elements on an array you pass and sets a value you want for each element - fills an array with a value
  for(int i = 0 ; i < myUserImage.pixels.length; i++){
    //check if there is a user for the current pixel, if so, use our custom colour for the pixel at this index
    if(sceneMap[i] > 0) myUserImage.pixels[i] = user1Colour;
  }
  myUserImage.updatePixels();

  //display image
  image(myUserImage,0,0);
}