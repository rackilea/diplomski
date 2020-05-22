public abstract class Model { // or even interface
    public String modelAsString();  // possibly just use Object.toString()
}

public class Maze extends Model { // or implement, if Model is interface
    private int i;
    ...
    public String modelAsString() { return "i = " + i; }
}

public SceneView(Model ms) {
    this.ms = ms;
    System.out.println(m.modelAsString()); // Now any Model subtype will work