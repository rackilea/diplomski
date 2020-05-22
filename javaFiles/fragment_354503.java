public class Mediator(){

    public Mediator(){ 
      MyBoard panel = new MyBoard(this);
      ...


 public class MyBoard extends JPanel implements MouseListener, MouseMotionListener {
        private Mediator mediator;

        public MyBoard(Mediator mediator)  {
              this.mediator = mediator;
        ...