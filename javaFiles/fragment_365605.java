public interface GameRect {
  int getX();
  int getY();
  int getHeight();
  int getWidth();
}

public class Actor implements GameRect {
  // implementation
}

public class Platform implements GameRect {
  // implementation
}

public class Rect {
    // implementation
    private GameRect parent;

    // constructor works for all classes that implement GameRect interface
    public Rect(GameRect gr) {
      parent = gr;
      x = gr.getX();
      y = gr.getY();
      // etc
    }
}