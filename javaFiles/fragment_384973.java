import java.util.ArrayList;
import java.util.Random;

/** Common interface for all training classes */
public abstract class TrainingClass {

  private Random rand = new Random();
  protected ArrayList<Exercise> exercises = new ArrayList<Exercise>();

  /** Run a random exercise */
  public String[] runRandomExercise() {
    int i = rand.nextInt(exercises.size());
    return exercises.get(i).run();
  }

}

/** Common interface for all exercises */ 
public interface Exercise {
  String[] run();
}

public class MatheMagic extends TrainingClass {

  /** Constructor creates all the exercises */
  public MatheMagic() {
    // Some exercise
    exercises.add(new Exercise {
      public String[] run() {
        // Code for some exercise ...
      }
    });
    // Some other exercise
    exercises.add(new Exercise {
      public String[] run() {
        // Code for some other exercise ...
      }
    });
    // etc ...
  }

}