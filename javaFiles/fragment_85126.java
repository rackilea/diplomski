import processing.core.PApplet;


public class MyGame extends PApplet {

    public void setup(){
        size(400,400);
        background(255);
        smooth();
        stroke(0,32);
    }
    public void draw(){
        fill(255,1);
        rect(0,0,width,height);
        translate(width/2,height/2);
        rotate(frameCount * .1f);
        line(0,0,width/3,0);
    }
    public void keyPressed(){
        if(key == 'f') exitFullscreen();
    }

    private void exitFullscreen() {
        frame.setBounds(0,0,width,height);
        setBounds((screenWidth - width) / 2,(screenHeight - height) / 2,width, height);
        frame.setLocation((screenWidth - width) / 2,(screenHeight - height) / 2);
        setLocation((screenWidth - width) / 2,(screenHeight - height) / 2);
    }
    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "MyGame" });
    }
}