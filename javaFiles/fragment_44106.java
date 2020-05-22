import java.util.Set;
import java.util.HashSet;
import java.awt.Component;

void draw(){

}

public interface System{
  public void accept(Set<Object> entities);
  public Set<Class<? extends Component>> required();
}

class PlayerInputSystem implements System {
  public void accept(Set<Object> entities) {
    // implementation here
  }

  public Set<Class<? extends Component>> required() {
    final Set<Class<? extends Component>> reqs = new HashSet<>();
    // implementation here
    return reqs;
  }
}