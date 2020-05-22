//Login Panel
public class MyPanel1 extends JFrame implements ActionListener{
    MyPanel2 p2 = new MyPanel2(this);
    .
    .
    public void actionPerformed(ActionEvent e){
       //if login is a success
         setVisible(false);
         p2.setVisible(true);  
    }
} 

//GUI Panel
public class MyPanel2 extends JFrame implements ActionListener{
   MyPanel1 p1;
   public MyPanel2(MyPanel1 parent){
       this.p1 = parent;
   }
   public void actionPerformed(ActionEvent e){
      //if logout button is clicked
        setVisible(false);
        p1.setVisible(true);  
   }
}