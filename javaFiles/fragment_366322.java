import java.awt.Frame;
Frame fullScreenFrame;
void setup(){
  fullScreenFrame = new  Frame();
  fullScreenFrame.setUndecorated(true);//prepare an undecorated fullscreen frame since java won't allow you to 'undecorate' a frame after it's been set visible 
  fullScreenFrame.setBounds(0,0,displayWidth,displayHeight);
  fullScreenFrame.addKeyListener(getKeyListeners()[0]);//pass key events from this applet to the fullScreen Frame
}
void draw(){
  background((float)mouseX/width * 255,(float)mouseY/height * 255,0);
}
void keyReleased(){
  if(key == 'f') {
      setBounds(0,0,displayWidth,displayHeight);//resize the skech
      fullScreenFrame.add(frame.getComponent(0));//add the applet to the fullscreen frame from Processing's frame
      fullScreenFrame.setVisible(true);//make our fullscreen frame visible
      frame.setVisible(false );//and hide Processing's frame
   }
}