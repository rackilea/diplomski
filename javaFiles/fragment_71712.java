public class But extends JButton implements MouseListener, MouseMotionListener {
    private MyGlassPane mgp;
    public But(MyGlassPane mgp){
        this.mgp = mgp;
    }
    public void mouseClicked(MouseEvent e) {
        mgp.show = true;
    }
 } 


 public Store(MyGlassPane mgp){
   //..
   But jb1 = new But(mgp);
   //..
 }