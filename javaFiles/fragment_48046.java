public interface IInteractionContext
{
  boolean getSomeObject( );
}

public class Main
  extends PApplet
  implements IInteractionContext
{
  @Override
  public boolean getSomeObject ( )
  {
    return someObject;
  }

  ...
}

public class Main Extends PApplet {

    ...

    public boolean getSomeObject ( )
    {
        return someObject;
    }
}

public class Interaction {

   final IInteractionContext ctx;

   public Interaction(IInteractionContext ctx)
   {
      this.ctx = ctx;
   }

   public void mousePressed() {

       if( ctx.getSomeObject( ) )
       {
           //do something
       }

   }
}