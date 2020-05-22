public abstract class Shape<S extends Stencil>
{
   public abstract void draw( S stencil );
}

public class Square extends Shape<Stencil1>
{
   public void draw( Stencil1 stencil )
   {
     stencil.letsdo();
     stencil.some();
     stencil.drawing();
   }
}

public class Circle extends Shape<Stencil2>
{
   public void draw( Stencil2 stencil )
   {
      stencil.some();
      stencil.more();
      stencil.drawing();
   }
}