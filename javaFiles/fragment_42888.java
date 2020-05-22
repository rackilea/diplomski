import SimpleOpenNI.*;

SimpleOpenNI  context;

SceneMapper sceneMap;

void setup()
{
  context = new SimpleOpenNI(this);
  context.enableScene();

  background(200,0,0);
  size(context.sceneWidth() , context.sceneHeight());

  sceneMap = new SceneMapper(context);
}

void draw()
{
  context.update(); 
  sceneMap.update();
  //display image
  image(sceneMap.scene,0,0);
}
class SceneMapper{
  PImage scene;//this is a PImage where we'll actually draw the user with what colour we want
  int[] sceneMap;//this will store scene data - an array of ints which has the same length as context.sceneImage().pixels, the only difference is, sceneImage already has colours set, while scene map has numbers representing user(1,2,3etc.) on top of background(0s)
  int numPixels;//total number of pixels, we only store it so we can reuse it
  color bg;//background colour
  color[] users = {color(255),color(192),color(127),color(64),color(32)};//fill colours for users

  SceneMapper(SimpleOpenNI context){
    numPixels = context.sceneWidth()*context.sceneHeight();
    sceneMap = new int[numPixels];//init scene nap array
    scene = createImage( context.sceneWidth(), context.sceneHeight(), RGB );//create a PImage to display scene data
    scene.loadPixels();  
    bg = color(0);
  }
  void update(){
    context.sceneMap(sceneMap);//ask SimpleOpenNI to store scene map data into our array
    Arrays.fill(scene.pixels, bg);//clear the image - fill it with the background colours
    for(int i = 0 ; i < numPixels ; i++){//loop through all pixels
      for(int u = 0 ; u < users.length; u++){//loop through user colours
        if(sceneMap[i] > 0) scene.pixels[i] = users[u];//if there are user pixels, use set user colour for those pixels (e.g. pixels with value 1 will use colours stored in users[0], pixels with value 2 will use colour from users[1], etc.) 
      } 
    }
    scene.updatePixels();//we've use pixels, so update the image at the end
  }
}