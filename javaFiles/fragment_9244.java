public interface Figure 
{
   public Drawable getDrawable();
}

public class State implements Figure
{
   private Rectangle rect;

   public Drawable getDrawable() { return rect; }

   //... State's real "work" below
}

public class Transition implements Figure
{
   private Line line;
   // you get the idea
}