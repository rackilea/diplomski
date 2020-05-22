import javax.swing.JFrame;

void setup() {

  ((JFrame)frame).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

  frame.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent we) {
      if (mouseX < 10) {
        frame.dispose();
      }
    }
  }
  );
}

void exit() {
  if(mouseX <10){
    super.exit();
  }
}


void draw() {
  background(0);
  ellipse(mouseX, mouseY, 10, 10);
}