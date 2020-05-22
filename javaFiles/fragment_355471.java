import processing.core.PApplet;

public class Assignment09b extends PApplet {
  // Create arrays to stort the x & y values of the mouse
  int [] xArray = new int [100];
  int [] yArray = new int [100];

  public void setup(){
      //Runs at 60Fps

      size(500, 500);
  }

  public void draw(){
      //Changes the background each frame
      background(0);

      updateArrays(mouseX,mouseY);

      //SHOULD print out the snake using series of ellipses
      for (int i = 0; i < xArray.length; i++){

          //Generates a random color each time
          fill(random(255), random(255), random(255));
          ellipse(xArray[i], yArray[i], 25, 25);
      }

  }

  private void updateArrays(int x,int y){
    arrayCopy(xArray, 0, xArray, 1, xArray.length-1);//shift all elements backwards by 1
    arrayCopy(yArray, 0, yArray, 1, yArray.length-1);//so x at index 99 goes 98, 98 to 97, etc. excepting index 0
    xArray[0] = x;//finally add the newest value 
    yArray[0] = y;//at the start of the array (so in the next loop it gets shifted over by 1) like the above values
  }
}