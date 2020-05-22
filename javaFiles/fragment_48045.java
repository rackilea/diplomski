public class Main Extends PApplet {

    ...

    public boolean getSomeObject ( )
    {
        return someObject;
    }
}

public class Interaction {

   PApplet p;

   public Interaction(PApplet parent){
      p = parent;
   }

   public void mousePressed() {

       if( p.getSomeObject( ) ) {
           //do something
       }

   }
}