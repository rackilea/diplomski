package frame;
import java.util.Scanner;
import javax.swing.JFrame ;

public class Frame_create {
public static void main(String args[]) {
  Frame_create fc = new Frame_create();
  JFrame myFrame = new JFrame() ;
  String myTitle = "blank frame" ;
  myFrame.setTitle(myTitle) ;
  myFrame.setSize(width, height) ;
  myFrame.setDefaultCloseOperation
      (JFrame.EXIT_ON_CLOSE) ;
  myFrame.setVisible(true) ;
  fc.input(args, myFrame);
}

static int width = 600 ; 
static int height = 200 ;
private Scanner readyread; 

public void input(String args[], JFrame myFrame){
    readyread = new
    Scanner(System.in);
    int inputNumber = readyread.nextInt();
    int increase = inputNumber*100 ;
    width += increase ;
    myFrame.setSize(width, height);
  }
}