public class Bullet extends JComponent {
 public void update() {
  if(y<-50)return; //if the bullet isnt out of the frame yet
  y-=5;           //move up
 }

 //all your other code for your bullet
}